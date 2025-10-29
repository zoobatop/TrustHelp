package br.com.TrustHelp.Model.Organizacao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "organizacao", uniqueConstraints = {
        @UniqueConstraint(name = "organizacao_org_cnpj_key", columnNames = {"org_cnpj"}),
        @UniqueConstraint(name = "organizacao_org_email_key", columnNames = {"org_email"})
})
public class Organizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizacao", nullable = false)
    private Integer id;

    @Column(name = "org_nome", nullable = false, length = 150)
    private String orgNome;

    @Column(name = "org_cnpj", nullable = false, length = 14)
    private String orgCnpj;

    @Column(name = "org_email", length = 100)
    private String orgEmail;

    @Column(name = "org_telefone", length = 15)
    private String orgTelefone;

    @ColumnDefault("true")
    @Column(name = "org_ativo")
    private Boolean orgAtivo;

}