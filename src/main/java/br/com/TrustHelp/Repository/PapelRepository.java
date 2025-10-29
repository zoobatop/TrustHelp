package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Papel.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {

    Optional<Papel> findById(Integer id);

    Optional<Papel> findByPapNome(String papNome);

    List<Papel> findByPapNomeContainingIgnoreCase(String papNome);

    @Query("SELECT p FROM Papel p WHERE LOWER(p.papNome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Papel> searchByNome(@Param("nome") String nome);

    boolean existsByPapNome(String papNome);
}