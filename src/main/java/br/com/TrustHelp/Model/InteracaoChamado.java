package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InteracaoChamado {
    private int id;
    private int chamadoId;
    private int usuarioId;
    private String mensagem;
    private String urlAnexo;
}