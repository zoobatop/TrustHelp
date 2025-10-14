package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Organizacao {
    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private boolean isAtivo = true;

}