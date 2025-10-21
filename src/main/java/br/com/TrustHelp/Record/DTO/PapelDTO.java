package br.com.TrustHelp.Record.DTO;

import br.com.TrustHelp.Enum.TipoPapel;

public record PapelDTO(
    int idPapel,
    TipoPapel tipoPapel,
    String descricao
) { }
