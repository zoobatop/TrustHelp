package br.com.TrustHelp.Model.Endereco;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.User.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_organizacao")
    private Organizacao idOrganizacao;

    @Column(name = "end_logradouro", nullable = false)
    private String endLogradouro;

    @Column(name = "end_numero", nullable = false, length = 10)
    private String endNumero;

    @Column(name = "end_complemento", length = 100)
    private String endComplemento;

    @Column(name = "end_cep", nullable = false, length = 8)
    private String endCep;

    @Column(name = "end_uf", nullable = false, length = 2)
    private String endUf;

}