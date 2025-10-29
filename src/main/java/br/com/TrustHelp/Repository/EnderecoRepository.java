package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findByIdUsuario_Id(Integer idUsuario);

    List<Endereco> findByIdOrganizacao_Id(Integer idOrganizacao);

    List<Endereco> findByEndCep(String endCep);

    List<Endereco> findByEndUfIgnoreCase(String endUf);

    List<Endereco> findByEndLogradouroContainingIgnoreCase(String logradouro);

    @Query("SELECT e FROM Endereco e WHERE " +
            "LOWER(e.endLogradouro) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(e.endComplemento) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "e.endCep LIKE CONCAT('%', :termo, '%') OR " +
            "LOWER(e.endUf) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Endereco> search(@Param("termo") String termo);

}