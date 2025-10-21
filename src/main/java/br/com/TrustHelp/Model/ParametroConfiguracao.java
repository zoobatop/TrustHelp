package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParametroConfiguracao {
    private int idParametro;
    private String chave;
    private String valor;
    private String categoria;
    private String descricao;
    private boolean isAtivo = true;
}