package br.com.TrustHelp.Model;

import br.com.TrustHelp.Enum.StatusChamado;
import br.com.TrustHelp.Enum.PrioridadeChamado;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Chamado {
    private int idChamado;
    private String titulo;
    private String descricao;
    private Organizacao organizacaoId;
    private int usuarioAberturaId;
    private int usuarioAtribuidoId;
    private StatusChamado status;
    private PrioridadeChamado prioridade;
}