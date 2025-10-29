package br.com.TrustHelp.Model.Papel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "papel", uniqueConstraints = {
        @UniqueConstraint(name = "papel_pap_nome_key", columnNames = {"pap_nome"})
})
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_papel", nullable = false)
    private Integer id;

    @Column(name = "pap_nome", nullable = false, length = 50)
    private String papNome;

    @Column(name = "pap_descricao", length = Integer.MAX_VALUE)
    private String papDescricao;

}