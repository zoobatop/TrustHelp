package br.com.TrustHelp.Service;

import br.com.TrustHelp.Model.Telefone;
import br.com.TrustHelp.Repository.TelefoneRepository;
import br.com.TrustHelp.Record.TelefoneDTO;
import br.com.TrustHelp.Record.TelefoneRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TelefoneService {
    private final TelefoneRepository telefoneRepository;

    public TelefoneService(final TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public List<TelefoneDTO> listarTodos() {
        return telefoneRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TelefoneDTO> buscarPorId(int id) {
        return telefoneRepository.findById(id).map(this::toDTO);
    }

    public TelefoneDTO criar(TelefoneRequest request) {
        Telefone telefone = fromRequest(request);
        return toDTO(telefoneRepository.save(telefone));
    }

    public Optional<TelefoneDTO> atualizar(int id, TelefoneRequest request) {
        if (telefoneRepository.existsById(id)) {
            Telefone telefone = fromRequest(request);
            telefone.setId(id);
            return Optional.of(toDTO(telefoneRepository.save(telefone)));
        }
        return Optional.empty();
    }

    public boolean deletar(int id) {
        if (telefoneRepository.existsById(id)) {
            telefoneRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private TelefoneDTO toDTO(Telefone t) {
        return new TelefoneDTO(
                t.getId(), t.getUserId(), t.getDdd(), t.getNumero(),
                t.getTipoTelefone(), t.isTelefonePrincipal(), t.isTelefoneAtivo()
        );
    }

    private Telefone fromRequest(TelefoneRequest r) {
        return Telefone.builder()
                .userId(r.userId())
                .ddd(r.ddd())
                .numero(r.numero())
                .tipoTelefone(r.tipoTelefone())
                .isTelefonePrincipal(r.telefonePrincipal())
                .isTelefoneAtivo(r.telefoneAtivo())
                .build();
    }
}
