package br.com.TrustHelp.Service.Chamado;

import br.com.TrustHelp.Model.Chamado.Chamado;
import br.com.TrustHelp.Model.Chamado.ChamadoInput;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Repository.ChamadoRepository;
import br.com.TrustHelp.Service.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private UserService userService;

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> findById(Integer id) {
        return chamadoRepository.findById(id);
    }

    public Chamado save(Chamado chamado) {
        // Setar timestamps automaticamente
        if (chamado.getChaCriadoEm() == null) {
            chamado.setChaCriadoEm(Instant.now());
        }
        chamado.setChaAtualizadoEm(Instant.now());

        return chamadoRepository.save(chamado);
    }

    public Chamado update(Integer id, Chamado chamadoDetails) {
        Optional<Chamado> optionalChamado = chamadoRepository.findById(id);

        if (optionalChamado.isPresent()) {
            Chamado chamado = optionalChamado.get();

            // Atualizar campos
            chamado.setChaTitulo(chamadoDetails.getChaTitulo());
            chamado.setChaDescricao(chamadoDetails.getChaDescricao());
            chamado.setIdOrganizacao(chamadoDetails.getIdOrganizacao());
            chamado.setIdUsuarioAbertura(chamadoDetails.getIdUsuarioAbertura());

            return chamadoRepository.save(chamado);
        }

        return null;
    }

    public boolean delete(Integer id) {
        if (chamadoRepository.existsById(id)) {
            chamadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Chamado atribuirUsuario(Integer idChamado, Integer idUsuario) {
        Optional<Chamado> optionalChamado = chamadoRepository.findById(idChamado);

        if (optionalChamado.isPresent()) {
            Chamado chamado = optionalChamado.get();

            chamado.setChaAtualizadoEm(Instant.now());
            return chamadoRepository.save(chamado);
        }

        return null;
    }

    public Chamado atualizarStatus(Integer id, String novoStatus) {
        Optional<Chamado> optionalChamado = chamadoRepository.findById(id);

        if (optionalChamado.isPresent()) {
            Chamado chamado = optionalChamado.get();
            chamado.setChaStatus(novoStatus);
            chamado.setChaAtualizadoEm(Instant.now());

            // Se status for finalizado, setar data de finalização
            if ("finalizado".equalsIgnoreCase(novoStatus) &&
                    chamado.getChaFinalizadoEm() == null) {
                chamado.setChaFinalizadoEm(Instant.now());
            }

            return chamadoRepository.save(chamado);
        }

        return null;
    }

    public List<Chamado> findByStatus(String status) {
        return chamadoRepository.findAll().stream()
                .filter(chamado -> status.equalsIgnoreCase(chamado.getChaStatus()))
                .toList();
    }

    public List<Chamado> findByOrganizacao(Integer idOrganizacao) {
        return chamadoRepository.findAll().stream()
                .filter(chamado -> chamado.getIdOrganizacao() != null &&
                        chamado.getIdOrganizacao().getId().equals(idOrganizacao))
                .toList();
    }

    public Chamado mapToEntity(ChamadoInput chamado) {
        Chamado entity = new Chamado();

        // Mapeia os campos básicos
        entity.setChaTitulo(chamado.getChaTitulo());
        entity.setChaDescricao(chamado.getChaDescricao());
        entity.setChaPrioridade(chamado.getChaPrioridade());

        // Busca o usuário de abertura pelo ID
        if (chamado.getIdUsuarioAbertura() != null && chamado.getIdUsuarioAbertura() > 0) {
            Usuario usuarioAbertura = userService.findById(chamado.getIdUsuarioAbertura());
            entity.setIdUsuarioAbertura(usuarioAbertura); // Usuario ao invés do id

            // Define a organização do usuário como organização do chamado
            if (usuarioAbertura.getIdOrganizacao() != null) {
                entity.setIdOrganizacao(usuarioAbertura.getIdOrganizacao()); // Organizacao ao invés do id
            } else {
                throw new IllegalArgumentException("Usuário não possui organização associada");
            }
        } else {
            throw new IllegalArgumentException("ID do usuário de abertura é obrigatório");
        }

        // Se tiver usuário atribuído, busca também
        if (chamado.getIdOrganizacao() != null && chamado.getIdUsuarioAbertura() > 0) {
            Usuario usuarioAtribuido = userService.findById(chamado.getIdUsuarioAbertura());
            entity.setIdUsuarioAtribuido(usuarioAtribuido);
        }

        // Outros campos
        if (chamado.getCategoria() != null) {
            entity.setChaStatus(chamado.getCategoria());
        }

        return entity;
    }
}