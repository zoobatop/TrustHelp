package br.com.TrustHelp.Model.Chamado;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.User.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "chamado")
@Data
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamado", nullable = false)
    private Integer id;

    @Column(name = "cha_titulo", nullable = false, length = 150)
    private String chaTitulo;

    @Column(name = "cha_descricao", nullable = false, length = Integer.MAX_VALUE)
    private String chaDescricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_organizacao", nullable = false)
    private Organizacao idOrganizacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_abertura", nullable = false)
    private Usuario idUsuarioAbertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_atribuido")
    private Usuario idUsuarioAtribuido;

    @ColumnDefault("'aberto'")
    @Column(name = "cha_status", nullable = false, length = 20)
    private String chaStatus;

    @ColumnDefault("'media'")
    @Column(name = "cha_prioridade", nullable = false, length = 20)
    private String chaPrioridade;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "cha_criado_em")
    private Instant chaCriadoEm;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "cha_atualizado_em")
    private Instant chaAtualizadoEm;

    @Column(name = "cha_finalizado_em")
    private Instant chaFinalizadoEm;

}