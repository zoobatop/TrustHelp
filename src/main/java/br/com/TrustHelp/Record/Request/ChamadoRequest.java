package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Enum.PrioridadeChamado;
import br.com.TrustHelp.Enum.StatusChamado;
import br.com.TrustHelp.Model.Organizacao;

public record ChamadoRequest(
        int idChamado,
        String titulo,
        String descricao,
        Organizacao organizacaoId,
        int usuarioAberturaId,
        int usuarioAtribuidoId,
        StatusChamado status,
        PrioridadeChamado prioridade
) {
}
