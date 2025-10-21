package br.com.TrustHelp.Record.DTO;

import br.com.TrustHelp.Enum.TipoTelefone;
import br.com.TrustHelp.Model.User;

public record TelefoneDTO(
        int idTelefone,
        User idUsuario,
        String ddd,
        String numero,
        TipoTelefone tipoTelefone,
        boolean telefonePrincipal,
        boolean telefoneAtivo
) {}
