package br.com.TrustHelp.Model.User.Output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioOutput {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("nome")
    private String nome;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("ativo")
    private Boolean ativo;
    
    @JsonProperty("id_papel")
    private Integer idPapel;
    
    @JsonProperty("id_organizacao")
    private Integer idOrganizacao;
    
    // Construtores
    public UsuarioOutput() {}
    
    public UsuarioOutput(Integer id, String nome, String email, Boolean ativo, 
                         Integer idPapel, String nomePapel, 
                         Integer idOrganizacao, String nomeOrganizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        this.idPapel = idPapel;
        this.idOrganizacao = idOrganizacao;
    }
}