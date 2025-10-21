package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class EmpresaAtendimento {
    private int idEmpresa;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
}