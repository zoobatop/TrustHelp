package br.com.TrustHelp.Record;

import br.com.TrustHelp.Enum.TipoTelefone;

public record TelefoneDTO(
        int id,
        int userId,
        String ddd,
        String numero,
        TipoTelefone tipoTelefone,
        boolean telefonePrincipal,
        boolean telefoneAtivo
) {}
