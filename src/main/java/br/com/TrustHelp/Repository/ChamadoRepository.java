package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Chamado.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    // Método correto - retorna Optional<Chamado>
    Optional<Chamado> findById(Integer id);
}