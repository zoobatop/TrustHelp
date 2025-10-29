package br.com.TrustHelp.Model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInfo {
    private Integer id;
    private String nome;
    private String email;
    private Boolean ativo;
}