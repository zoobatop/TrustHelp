package br.com.TrustHelp.Service.Chamado;

import br.com.TrustHelp.Model.Chamado.Chamado;
import br.com.TrustHelp.Model.Chamado.ChamadoInfo;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

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
}