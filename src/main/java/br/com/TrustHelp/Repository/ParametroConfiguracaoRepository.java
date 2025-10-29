package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.ParametroConfiguracao.ParametroConfiguracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.time.Instant;

@Repository
public interface ParametroConfiguracaoRepository extends JpaRepository<ParametroConfiguracao, Integer> {

    // Buscar por chave exata
    Optional<ParametroConfiguracao> findByParChave(String parChave);

    // Buscar por categoria
    List<ParametroConfiguracao> findByParCategoria(String parCategoria);

    // Buscar parâmetros ativos
    List<ParametroConfiguracao> findByParAtivoTrue();

    // Buscar parâmetros inativos
    List<ParametroConfiguracao> findByParAtivoFalse();

    // Buscar por categoria e status
    List<ParametroConfiguracao> findByParCategoriaAndParAtivo(String parCategoria, Boolean parAtivo);

    // Buscar por chave contendo termo
    List<ParametroConfiguracao> findByParChaveContainingIgnoreCase(String chave);

    // Buscar por valor contendo termo
    List<ParametroConfiguracao> findByParValorContainingIgnoreCase(String valor);

    // Buscar por descrição contendo termo
    List<ParametroConfiguracao> findByParDescricaoContainingIgnoreCase(String descricao);

    // Busca geral por múltiplos campos
    @Query("SELECT p FROM ParametroConfiguracao p WHERE " +
            "LOWER(p.parChave) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(p.parValor) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(p.parCategoria) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(p.parDescricao) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<ParametroConfiguracao> search(@Param("termo") String termo);

    // Verificar se chave existe
    boolean existsByParChave(String parChave);

    // Verificar se chave existe excluindo um ID específico (para update)
    boolean existsByParChaveAndIdNot(String parChave, Integer id);

    // Buscar categorias distintas
    @Query("SELECT DISTINCT p.parCategoria FROM ParametroConfiguracao p ORDER BY p.parCategoria")
    List<String> findDistinctCategorias();

    // Buscar parâmetros por múltiplas categorias
    List<ParametroConfiguracao> findByParCategoriaIn(List<String> categorias);

    // Buscar valor por chave (método útil para configurações)
    @Query("SELECT p.parValor FROM ParametroConfiguracao p WHERE p.parChave = :chave AND p.parAtivo = true")
    Optional<String> findValorByChave(@Param("chave") String chave);

    // Contar parâmetros por categoria
    @Query("SELECT p.parCategoria, COUNT(p) FROM ParametroConfiguracao p GROUP BY p.parCategoria")
    List<Object[]> countByCategoria();

    // Buscar parâmetros atualizados após uma data
    List<ParametroConfiguracao> findByParAtualizadoEmAfter(Instant data);
}