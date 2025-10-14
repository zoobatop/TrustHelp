package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Endereco {
    private int id;
    private int usuarioId;
    private int organizacaoId;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String uf;
}
