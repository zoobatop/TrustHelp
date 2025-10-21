package br.com.TrustHelp.Record.Request;

public record ParametroConfiguracaoRequest(
        int idParametro,
        String chave,
        String valor,
        String categoria,
        String descricao,
        boolean isAtivo
) { }
