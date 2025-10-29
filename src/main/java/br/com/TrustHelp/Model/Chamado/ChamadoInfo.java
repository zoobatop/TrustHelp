package br.com.TrustHelp.Model.Chamado;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.User.Usuario;
import lombok.Setter;
import lombok.Getter;

import java.time.Instant;

@Getter
@Setter
public class ChamadoInfo {
    private Integer id;
    private String chaTitulo;
    private String chaDescricao;
    private Organizacao idOrganizacao;
    private Usuario idUsuarioAbertura;
    private Usuario idUsuarioAtribuido;
    private String chaStatus;
    private String chaPrioridade;
    private Instant chaCriadoEm;
    private Instant chaAtualizadoEm;
    private Instant chaFinalizadoEm;
}
