package br.com.TrustHelp.Record.DTO;

public record ParametroConfiguracaoDTO(
        int id,
        String chave,
        String valor,
        String categoria,
        String descricao,
        boolean isAtivo
) { }
