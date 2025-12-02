package br.com.TrustHelp.Model.Chamado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamadoInput {
    private String chaTitulo;
    private String chaDescricao;
    private String chaPrioridade;
    private Integer idOrganizacao;
    private Integer idUsuarioAbertura; 
    private String categoria;
}
