package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamado;
import br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamadoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.time.Instant;

@Repository
public interface InteracaoChamadoRepository extends JpaRepository<InteracaoChamado, Integer> {

    // Buscar todas as interações de um chamado
    List<InteracaoChamado> findByIdChamado_IdOrderByIntCriadoEmAsc(Integer idChamado);

    // Buscar todas as interações de um usuário
    List<InteracaoChamado> findByIdUsuario_IdOrderByIntCriadoEmDesc(Integer idUsuario);

    // Buscar interações com anexos
    List<InteracaoChamado> findByIntUrlAnexoIsNotNull();

    // Buscar interações de um chamado com anexos
    List<InteracaoChamado> findByIdChamado_IdAndIntUrlAnexoIsNotNull(Integer idChamado);

    // Buscar última interação de um chamado
    Optional<InteracaoChamado> findFirstByIdChamado_IdOrderByIntCriadoEmDesc(Integer idChamado);

    // Contar interações de um chamado
    Long countByIdChamado_Id(Integer idChamado);

    // Buscar interações por período
    @Query("SELECT i FROM InteracaoChamado i WHERE i.intCriadoEm BETWEEN :dataInicio AND :dataFim ORDER BY i.intCriadoEm DESC")
    List<InteracaoChamado> findByPeriodo(@Param("dataInicio") Instant dataInicio, @Param("dataFim") Instant dataFim);

    // Buscar interações com informações do usuário (para o Info)
    @Query("SELECT new br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamadoInfo(" +
            "i.id, i.idChamado.id, i.idUsuario.id, u.nome, i.intMensagem, i.intUrlAnexo, i.intCriadoEm) " +
            "FROM InteracaoChamado i JOIN i.idUsuario u " +
            "WHERE i.idChamado.id = :idChamado " +
            "ORDER BY i.intCriadoEm ASC")
    List<InteracaoChamadoInfo> findInteracaoInfoByChamadoId(@Param("idChamado") Integer idChamado);

    // Verificar se usuário tem interação no chamado
    boolean existsByIdChamado_IdAndIdUsuario_Id(Integer idChamado, Integer idUsuario);

    // Buscar interações por usuário em um chamado específico
    List<InteracaoChamado> findByIdChamado_IdAndIdUsuario_IdOrderByIntCriadoEmDesc(Integer idChamado, Integer idUsuario);
}