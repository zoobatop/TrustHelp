package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Permissao.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

    // Buscar por nome exato
    Optional<Permissao> findByPerNome(String perNome);

    // Buscar por nome contendo termo (case insensitive)
    List<Permissao> findByPerNomeContainingIgnoreCase(String perNome);

    // Buscar por descrição contendo termo (case insensitive)
    List<Permissao> findByPerDescricaoContainingIgnoreCase(String perDescricao);

    // Buscar todas as permissões ordenadas por nome
    List<Permissao> findAllByOrderByPerNomeAsc();

    // Verificar se nome existe
    boolean existsByPerNome(String perNome);

    // Verificar se nome existe excluindo um ID específico (para update)
    boolean existsByPerNomeAndIdNot(String perNome, Integer id);

    // Busca geral por múltiplos campos
    @Query("SELECT p FROM Permissao p WHERE " +
            "LOWER(p.perNome) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(p.perDescricao) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Permissao> search(@Param("termo") String termo);

    // Buscar permissões por IDs
    List<Permissao> findByIdIn(List<Integer> ids);

    // Buscar nomes das permissões por IDs
    @Query("SELECT p.perNome FROM Permissao p WHERE p.id IN :ids")
    List<String> findNomesByIds(@Param("ids") List<Integer> ids);

    // Contar permissões
    long count();
}