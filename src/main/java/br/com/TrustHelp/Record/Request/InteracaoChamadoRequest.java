package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Model.Chamado;
import br.com.TrustHelp.Model.User;

public record InteracaoChamadoRequest(
        int idInteracao,
        Chamado idChamado,
        User idUsuario,
        String mensagem,
        String urlAnexo
) {
}
