package br.com.TrustHelp.Service.PapelPermissao;

import br.com.TrustHelp.Model.PapelPermissao.PapelPermissaoInfo;
import br.com.TrustHelp.Model.PapelPermissao.PapelPermissao;
import br.com.TrustHelp.Model.PapelPermissao.PapelPermissaoId;
import br.com.TrustHelp.Repository.PapelPermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PapelPermissaoService {

    private final PapelPermissaoRepository repository;

    public List<PapelPermissaoInfo> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toInfo)
                .collect(Collectors.toList());
    }

    public List<PapelPermissaoInfo> listarPorPapel(Integer idPapel) {
        return repository.findByIdIdPapel(idPapel)
                .stream()
                .map(this::toInfo)
                .collect(Collectors.toList());
    }

    public Optional<PapelPermissaoInfo> buscarPorId(Integer idPapel, Integer idPermissao) {
        PapelPermissaoId id = new PapelPermissaoId();
        id.setIdPapel(idPapel);
        id.setIdPermissao(idPermissao);
        return repository.findById(id).map(this::toInfo);
    }

    public PapelPermissao salvar(PapelPermissao papelPermissao) {
        return repository.save(papelPermissao);
    }

    public void deletar(Integer idPapel, Integer idPermissao) {
        PapelPermissaoId id = new PapelPermissaoId();
        id.setIdPapel(idPapel);
        id.setIdPermissao(idPermissao);
        repository.deleteById(id);
    }

    private PapelPermissaoInfo toInfo(PapelPermissao entity) {
        PapelPermissaoInfo info = new PapelPermissaoInfo();
        info.setIdPapel(entity.getId().getIdPapel());
        info.setIdPermissao(entity.getId().getIdPermissao());
        return info;
    }
}
