package br.com.TrustHelp.Model.User.Input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;
    private int idPapel;
    private int idOrganizacao;
    
    // Construtores
    public UsuarioInput() {}
    
    public UsuarioInput(String nome, String email, String senha, Boolean isAtivo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = isAtivo;
    }
    
}
