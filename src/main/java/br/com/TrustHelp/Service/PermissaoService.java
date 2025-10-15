package br.com.TrustHelp.Service;

import br.com.TrustHelp.Model.Permissao;
import br.com.TrustHelp.Repository.PermissaoRepository;
import br.com.TrustHelp.Record.PermissaoDTO;
import br.com.TrustHelp.Record.PermissaoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissaoService {
    private final PermissaoRepository permissaoRepository;

    public PermissaoService(final PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }

    public List<PermissaoDTO> listarTodos() {
        return permissaoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PermissaoDTO> buscarPorId(int id) {
        return permissaoRepository.findById(id).map(this::toDTO);
    }

    public PermissaoDTO criar(PermissaoRequest request) {
        Permissao permissao = fromRequest(request);
        return toDTO(permissaoRepository.save(permissao));
    }

    public Optional<PermissaoDTO> atualizar(int id, PermissaoRequest request) {
        if (permissaoRepository.existsById(id)) {
            Permissao permissao = fromRequest(request);
            permissao.setId(id);
            return Optional.of(toDTO(permissaoRepository.save(permissao)));
        }
        return Optional.empty();
    }

    public boolean deletar(int id) {
        if (permissaoRepository.existsById(id)) {
            permissaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PermissaoDTO toDTO(Permissao p) {
        return new PermissaoDTO(p.getId(), p.getNome(), p.getDescricao());
    }

    private Permissao fromRequest(PermissaoRequest r) {
        return Permissao.builder()
                .nome(r.nome())
                .descricao(r.descricao())
                .build();
    }
}
