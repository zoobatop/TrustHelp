package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InteracaoChamado {
    private int idInteracao;
    private Chamado idChamado;
    private User idUsuario;
    private String mensagem;
    private String urlAnexo;
}