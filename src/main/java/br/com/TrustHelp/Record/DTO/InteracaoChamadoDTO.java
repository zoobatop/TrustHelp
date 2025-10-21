package br.com.TrustHelp.Record.DTO;

public record InteracaoChamadoDTO(
    int id,
    int chamadoId,
    int usuarioId,
    String mensagem,
    String urlAnexo
) { }
