package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private boolean isAtivo = true;
    private Papel papelId;
    private Organizacao organizacaoId;
}