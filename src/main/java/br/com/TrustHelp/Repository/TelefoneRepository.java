package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Telefone.Telefone;
import br.com.TrustHelp.Model.Telefone.TelefoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

    // Buscar telefones por usuário
    List<Telefone> findByIdUsuario_IdOrderByTelPrincipalDesc(Integer idUsuario);

    // Buscar telefones ativos por usuário
    List<Telefone> findByIdUsuario_IdAndTelAtivoTrueOrderByTelPrincipalDesc(Integer idUsuario);

    // Buscar telefone principal do usuário
    Optional<Telefone> findByIdUsuario_IdAndTelPrincipalTrue(Integer idUsuario);

    // Buscar telefone por DDD e número
    Optional<Telefone> findByTelDddAndTelNumero(String telDdd, String telNumero);

    // Buscar telefones por tipo
    List<Telefone> findByTelTipo(String telTipo);

    // Buscar telefones por DDD
    List<Telefone> findByTelDdd(String telDdd);

    // Buscar telefones ativos
    List<Telefone> findByTelAtivoTrue();

    // Buscar telefones inativos
    List<Telefone> findByTelAtivoFalse();

    // Verificar se telefone existe (DDD + número)
    boolean existsByTelDddAndTelNumero(String telDdd, String telNumero);

    // Verificar se telefone existe excluindo um ID específico
    boolean existsByTelDddAndTelNumeroAndIdNot(String telDdd, String telNumero, Integer id);

    // Verificar se usuário tem telefone principal
    boolean existsByIdUsuario_IdAndTelPrincipalTrue(Integer idUsuario);

    // Buscar informações completas dos telefones
    @Query("SELECT new br.com.TrustHelp.Model.Telefone.TelefoneInfo(" +
            "t.id, t.idUsuario.id, u.nome, t.telDdd, t.telNumero, " +
            "t.telTipo, t.telPrincipal, t.telAtivo, t.createdAt) " +
            "FROM Telefone t JOIN t.idUsuario u " +
            "WHERE t.idUsuario.id = :idUsuario " +
            "ORDER BY t.telPrincipal DESC, t.createdAt DESC")
    List<TelefoneInfo> findInfoByUsuarioId(@Param("idUsuario") Integer idUsuario);

    // Buscar telefones por múltiplos usuários
    List<Telefone> findByIdUsuario_IdIn(List<Integer> usuariosIds);

    // Buscar telefones por tipo e DDD
    List<Telefone> findByTelTipoAndTelDdd(String telTipo, String telDdd);

    // Desativar todos os telefones de um usuário
    @Modifying
    @Query("UPDATE Telefone t SET t.telAtivo = false WHERE t.idUsuario.id = :idUsuario")
    void desativarTodosTelefonesUsuario(@Param("idUsuario") Integer idUsuario);

    // Remover telefone principal de um usuário
    @Modifying
    @Query("UPDATE Telefone t SET t.telPrincipal = false WHERE t.idUsuario.id = :idUsuario AND t.telPrincipal = true")
    void removerTelefonePrincipal(@Param("idUsuario") Integer idUsuario);

    // Definir telefone como principal
    @Modifying
    @Query("UPDATE Telefone t SET t.telPrincipal = true WHERE t.id = :idTelefone")
    void definirComoPrincipal(@Param("idTelefone") Integer idTelefone);

    // Buscar telefones criados após uma data
    List<Telefone> findByCreatedAtAfter(java.time.Instant data);

    // Contar telefones por usuário
    @Query("SELECT COUNT(t) FROM Telefone t WHERE t.idUsuario.id = :idUsuario")
    Long countByIdUsuario(@Param("idUsuario") Integer idUsuario);

    // Buscar telefones por parte do número
    List<Telefone> findByTelNumeroContaining(String numero);
}