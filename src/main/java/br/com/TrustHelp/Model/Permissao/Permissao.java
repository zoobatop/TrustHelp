package br.com.TrustHelp.Model.Permissao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permissao", uniqueConstraints = {
        @UniqueConstraint(name = "permissao_per_nome_key", columnNames = {"per_nome"})
})
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao", nullable = false)
    private Integer id;

    @Column(name = "per_nome", nullable = false, length = 50)
    private String perNome;

    @Column(name = "per_descricao", length = Integer.MAX_VALUE)
    private String perDescricao;

}