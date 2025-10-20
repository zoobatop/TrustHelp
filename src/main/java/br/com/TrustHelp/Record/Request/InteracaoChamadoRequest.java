package br.com.TrustHelp.Record.Request;

public record InteracaoChamadoRequest(
        int id,
        int chamadoId,
        int usuarioId,
        String mensagem,
        String urlAnexo
) {
}
