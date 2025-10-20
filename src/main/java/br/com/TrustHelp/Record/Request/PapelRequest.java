package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Enum.TipoPapel;

public record PapelRequest(
        int id,
        TipoPapel tipoPapel,
        String descricao
) { }
