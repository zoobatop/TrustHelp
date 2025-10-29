package br.com.TrustHelp.Model.InteracaoChamado;

import br.com.TrustHelp.Model.Chamado.Chamado;
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
@Table(name = "interacao_chamado")
public class InteracaoChamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interacao", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_chamado", nullable = false)
    private Chamado idChamado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "int_mensagem", nullable = false, length = Integer.MAX_VALUE)
    private String intMensagem;

    @Column(name = "int_url_anexo")
    private String intUrlAnexo;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "int_criado_em")
    private Instant intCriadoEm;
}