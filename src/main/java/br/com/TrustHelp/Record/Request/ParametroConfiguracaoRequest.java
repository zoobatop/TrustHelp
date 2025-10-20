package br.com.TrustHelp.Record.Request;

public record ParametroConfiguracaoRequest(
        int id,
        String chave,
        String valor,
        String categoria,
        String descricao,
        boolean isAtivo
) { }
