package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Enum.TipoTelefone;

public record TelefoneRequest(
        int userId,
        String ddd,
        String numero,
        TipoTelefone tipoTelefone,
        boolean telefonePrincipal,
        boolean telefoneAtivo
) {}
