package br.com.TrustHelp.Record.DTO;

import br.com.TrustHelp.Enum.PrioridadeChamado;
import br.com.TrustHelp.Enum.StatusChamado;

public record ChamadoDTO(
        int id,
        String titulo,
        String descricao,
        int organizacaoId,
        int usuarioAberturaId,
        int usuarioAtribuidoId,
        StatusChamado status,
        PrioridadeChamado prioridade
        ) { }
