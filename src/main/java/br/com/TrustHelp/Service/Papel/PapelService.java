package br.com.TrustHelp.Service.Papel;

import br.com.TrustHelp.Model.Papel.Papel;
import br.com.TrustHelp.Model.Papel.PapelOutput;
import br.com.TrustHelp.Model.Papel.PapelInput;
import br.com.TrustHelp.Repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PapelService {

    @Autowired
    private PapelRepository papelRepository;

    public List<PapelOutput> findAll() {
        List<Papel> papeis = papelRepository.findAll();
        return this.toResponseList(papeis);
    }

    public Optional<Papel> findById(Integer id) {
        return papelRepository.findById(id);
    }

    public Optional<Papel> findByNome(String nome) {
        return papelRepository.findByPapNome(nome);
    }

    public Papel save(PapelInput papel) {
        // Validação básica antes de salvar
        if (papel.getNome() == null || papel.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do papel é obrigatório");
        }

        Papel papelInstance = new Papel();
        papelInstance.setPapNome(papel.getNome().toUpperCase().trim());
        papelInstance.setPapDescricao(papel.getDescricao());

        return papelRepository.save(papelInstance);
    }

    public Papel update(Integer id, Papel papelDetails) {
        Optional<Papel> optionalPapel = papelRepository.findById(id);

        if (optionalPapel.isPresent()) {
            Papel papel = optionalPapel.get();

            // Atualizar campos se não forem nulos
            if (papelDetails.getPapNome() != null) {
                papel.setPapNome(papelDetails.getPapNome().toUpperCase().trim());
            }
            if (papelDetails.getPapDescricao() != null) {
                papel.setPapDescricao(papelDetails.getPapDescricao().trim());
            }

            return papelRepository.save(papel);
        }

        return null;
    }

    public boolean delete(Integer id) {
        if (papelRepository.existsById(id)) {
            papelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsByNome(String nome) {
        return papelRepository.findByPapNome(nome.toUpperCase()).isPresent();
    }

    public List<Papel> findByNomeContaining(String nome) {
        return papelRepository.findByPapNomeContainingIgnoreCase(nome);
    }

    public Papel createIfNotExists(String nome, String descricao) {
        Optional<Papel> papelExistente = papelRepository.findByPapNome(nome.toUpperCase());

        if (papelExistente.isPresent()) {
            return papelExistente.get();
        }

        Papel novoPapel = new Papel();
        novoPapel.setPapNome(nome.toUpperCase());
        novoPapel.setPapDescricao(descricao);

        return papelRepository.save(novoPapel);
    }

    private List<PapelOutput> toResponseList(List<Papel> papeis) {
        return papeis.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    private PapelOutput toResponse(Papel papel) {
        return new PapelOutput(
            papel.getId(),
            papel.getPapNome(),
            papel.getPapDescricao()
        );
    }
}