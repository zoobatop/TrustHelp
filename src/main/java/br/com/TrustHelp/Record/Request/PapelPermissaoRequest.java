package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Model.PapelPermissao;

public record PapelPermissaoRequest(
        PapelPermissao idPapel,
        PapelPermissao idPermissao
) {
}
