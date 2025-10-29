package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Integer> {
    Optional<Organizacao> findByOrgCnpj(String cnpj);
    Optional<Organizacao> findByOrgEmail(String email);
    Optional<Organizacao> findByOrgNome(String nome);
}