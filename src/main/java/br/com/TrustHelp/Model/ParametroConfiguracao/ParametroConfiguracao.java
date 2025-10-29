package br.com.TrustHelp.Model.ParametroConfiguracao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "parametro_configuracao", uniqueConstraints = {
        @UniqueConstraint(name = "parametro_configuracao_par_chave_key", columnNames = {"par_chave"})
})
public class ParametroConfiguracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro", nullable = false)
    private Integer id;

    @Column(name = "par_chave", nullable = false, length = 100)
    private String parChave;

    @Column(name = "par_valor", nullable = false, length = 500)
    private String parValor;

    @Column(name = "par_categoria", nullable = false, length = 50)
    private String parCategoria;

    @Column(name = "par_descricao", length = Integer.MAX_VALUE)
    private String parDescricao;

    @ColumnDefault("true")
    @Column(name = "par_ativo")
    private Boolean parAtivo;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "par_atualizado_em")
    private Instant parAtualizadoEm;

}