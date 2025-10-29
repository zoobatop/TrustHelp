package br.com.TrustHelp.Model.PapelPermissao;

import br.com.TrustHelp.Model.Papel.Papel;
import br.com.TrustHelp.Model.Permissao.Permissao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "papel_permissao")
public class PapelPermissao {
    @EmbeddedId
    private PapelPermissaoId id;

    @MapsId("idPapel")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_papel", nullable = false)
    private Papel idPapel;

    @MapsId("idPermissao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_permissao", nullable = false)
    private Permissao idPermissao;

}