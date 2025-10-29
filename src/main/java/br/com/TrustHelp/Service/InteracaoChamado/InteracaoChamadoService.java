package br.com.TrustHelp.Service.InteracaoChamado;

import br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamado;
import br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamadoInfo;
import br.com.TrustHelp.Repository.InteracaoChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class InteracaoChamadoService {

    @Autowired
    private InteracaoChamadoRepository interacaoChamadoRepository;

    public List<InteracaoChamado> findAll() {
        return interacaoChamadoRepository.findAll();
    }

    public Optional<InteracaoChamado> findById(Integer id) {
        return interacaoChamadoRepository.findById(id);
    }

    public List<InteracaoChamado> findByChamadoId(Integer idChamado) {
        return interacaoChamadoRepository.findByIdChamado_IdOrderByIntCriadoEmAsc(idChamado);
    }

    public List<InteracaoChamadoInfo> findInfoByChamadoId(Integer idChamado) {
        return interacaoChamadoRepository.findInteracaoInfoByChamadoId(idChamado);
    }

    public List<InteracaoChamado> findByUsuarioId(Integer idUsuario) {
        return interacaoChamadoRepository.findByIdUsuario_IdOrderByIntCriadoEmDesc(idUsuario);
    }

    public List<InteracaoChamado> findInteracoesComAnexo() {
        return interacaoChamadoRepository.findByIntUrlAnexoIsNotNull();
    }

    public List<InteracaoChamado> findInteracoesComAnexoByChamado(Integer idChamado) {
        return interacaoChamadoRepository.findByIdChamado_IdAndIntUrlAnexoIsNotNull(idChamado);
    }

    public Optional<InteracaoChamado> findUltimaInteracaoByChamado(Integer idChamado) {
        return interacaoChamadoRepository.findFirstByIdChamado_IdOrderByIntCriadoEmDesc(idChamado);
    }

    public Long countInteracoesByChamado(Integer idChamado) {
        return interacaoChamadoRepository.countByIdChamado_Id(idChamado);
    }

    public List<InteracaoChamado> findByPeriodo(Instant dataInicio, Instant dataFim) {
        return interacaoChamadoRepository.findByPeriodo(dataInicio, dataFim);
    }

    public InteracaoChamado save(InteracaoChamado interacaoChamado) {
        validateInteracaoChamado(interacaoChamado);

        if (interacaoChamado.getIntCriadoEm() == null) {
            interacaoChamado.setIntCriadoEm(Instant.now());
        }

        return interacaoChamadoRepository.save(interacaoChamado);
    }

    public InteracaoChamado update(Integer id, InteracaoChamado interacaoDetails) {
        Optional<InteracaoChamado> optionalInteracao = interacaoChamadoRepository.findById(id);

        if (optionalInteracao.isPresent()) {
            InteracaoChamado interacao = optionalInteracao.get();

            // Atualizar campos permitidos (não atualizamos chamado nem usuário)
            if (interacaoDetails.getIntMensagem() != null) {
                interacao.setIntMensagem(interacaoDetails.getIntMensagem().trim());
            }
            if (interacaoDetails.getIntUrlAnexo() != null) {
                interacao.setIntUrlAnexo(interacaoDetails.getIntUrlAnexo().trim());
            }

            return interacaoChamadoRepository.save(interacao);
        }

        return null;
    }

    public boolean delete(Integer id) {
        if (interacaoChamadoRepository.existsById(id)) {
            interacaoChamadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean usuarioTemInteracaoNoChamado(Integer idChamado, Integer idUsuario) {
        return interacaoChamadoRepository.existsByIdChamado_IdAndIdUsuario_Id(idChamado, idUsuario);
    }

    public List<InteracaoChamado> findInteracoesByUsuarioNoChamado(Integer idChamado, Integer idUsuario) {
        return interacaoChamadoRepository.findByIdChamado_IdAndIdUsuario_IdOrderByIntCriadoEmDesc(idChamado, idUsuario);
    }

    public InteracaoChamado criarInteracao(Integer idChamado, Integer idUsuario, String mensagem, String urlAnexo) {
        // Aqui você precisaria carregar as entidades Chamado e Usuario
        // Por simplicidade, vou criar um objeto mínimo
        InteracaoChamado interacao = new InteracaoChamado();

        // Em uma implementação real, você carregaria as entidades do banco
        // Chamado chamado = chamadoRepository.findById(idChamado).orElseThrow(...);
        // Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(...);

        // interacao.setIdChamado(chamado);
        // interacao.setIdUsuario(usuario);

        interacao.setIntMensagem(mensagem);
        interacao.setIntUrlAnexo(urlAnexo);
        interacao.setIntCriadoEm(Instant.now());

        return save(interacao);
    }

    private void validateInteracaoChamado(InteracaoChamado interacao) {
        if (interacao.getIdChamado() == null) {
            throw new IllegalArgumentException("Chamado é obrigatório");
        }

        if (interacao.getIdUsuario() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório");
        }

        if (interacao.getIntMensagem() == null || interacao.getIntMensagem().trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem da interação é obrigatória");
        }

        if (interacao.getIntMensagem().length() > 10000) {
            throw new IllegalArgumentException("Mensagem muito longa. Máximo 10.000 caracteres");
        }
    }

    public long count() {
        return interacaoChamadoRepository.count();
    }

    public List<InteracaoChamado> findRecentInteractions(int limit) {
        return interacaoChamadoRepository.findAll().stream()
                .sorted((i1, i2) -> i2.getIntCriadoEm().compareTo(i1.getIntCriadoEm()))
                .limit(limit)
                .toList();
    }
}