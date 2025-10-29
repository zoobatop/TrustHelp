package br.com.TrustHelp.Model.Telefone;

import br.com.TrustHelp.Model.User.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "telefone", indexes = {
        @Index(name = "idx_telefone_principal", columnList = "id_usuario, tel_principal"),
        @Index(name = "idx_telefone_usuario", columnList = "id_usuario")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uk_telefone_unico", columnNames = {"tel_ddd", "tel_numero"})
})
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "tel_ddd", nullable = false, length = 3)
    private String telDdd;

    @Column(name = "tel_numero", nullable = false, length = 11)
    private String telNumero;

    @ColumnDefault("'CELULAR'")
    @Column(name = "tel_tipo", length = 20)
    private String telTipo;

    @ColumnDefault("false")
    @Column(name = "tel_principal")
    private Boolean telPrincipal;

    @ColumnDefault("true")
    @Column(name = "tel_ativo")
    private Boolean telAtivo;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}