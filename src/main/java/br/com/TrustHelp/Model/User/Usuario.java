package br.com.TrustHelp.Model.User;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.Papel.Papel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(name = "usuario_usu_email_key", columnNames = {"usu_email"})
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column(name = "usu_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "usu_email", nullable = false, length = 100)
    private String email;

    @Column(name = "usu_senha", nullable = false)
    private String password;

    @ColumnDefault("true")
    @Column(name = "usu_ativo")
    private Boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_papel", nullable = false)
    private Papel idPapel;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_organizacao")
    private Organizacao idOrganizacao;
}