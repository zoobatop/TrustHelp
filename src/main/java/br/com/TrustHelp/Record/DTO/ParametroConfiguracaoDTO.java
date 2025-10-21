package br.com.TrustHelp.Record.DTO;

public record ParametroConfiguracaoDTO(
        int idParametro,
        String chave,
        String valor,
        String categoria,
        String descricao,
        boolean isAtivo
) { }
