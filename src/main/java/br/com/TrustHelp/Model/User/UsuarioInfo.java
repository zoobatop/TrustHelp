package br.com.TrustHelp.Model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInfo {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;
    private Integer idPapel;
    private Integer idOrganizacao;
}