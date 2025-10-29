package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.PapelPermissao.PapelPermissao;
import br.com.TrustHelp.Model.PapelPermissao.PapelPermissaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PapelPermissaoRepository extends JpaRepository<PapelPermissao, PapelPermissaoId> {

    List<PapelPermissao> findByIdIdPapel(Integer idPapel);
    List<PapelPermissao> findByIdIdPermissao(Integer idPermissao);

}
