package br.com.TrustHelp.Model.PapelPermissao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PapelPermissaoId implements Serializable {
    private static final long serialVersionUID = 4837311380622318071L;
    @Column(name = "id_papel", nullable = false)
    private Integer idPapel;

    @Column(name = "id_permissao", nullable = false)
    private Integer idPermissao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PapelPermissaoId entity = (PapelPermissaoId) o;
        return Objects.equals(this.idPapel, entity.idPapel) &&
                Objects.equals(this.idPermissao, entity.idPermissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPapel, idPermissao);
    }

}