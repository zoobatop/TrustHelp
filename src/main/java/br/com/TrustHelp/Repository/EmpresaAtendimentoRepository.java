package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.EmpresaAtendimento.EmpresaAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaAtendimentoRepository extends JpaRepository<EmpresaAtendimento, Integer> {

    Optional<EmpresaAtendimento> findById(Integer id);

    Optional<EmpresaAtendimento> findByEmpCnpj(String empCnpj);

    Optional<EmpresaAtendimento> findByEmpEmail(String empEmail);

    List<EmpresaAtendimento> findByEmpNomeContainingIgnoreCase(String empNome);

    @Query("SELECT e FROM EmpresaAtendimento e WHERE " +
            "LOWER(e.empNome) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "e.empCnpj LIKE CONCAT('%', :termo, '%')")
    List<EmpresaAtendimento> findByEmpNomeContainingIgnoreCaseOrEmpCnpjContaining(
            @Param("termo") String termo);

    boolean existsByEmpCnpj(String empCnpj);

    boolean existsByEmpEmail(String empEmail);
}