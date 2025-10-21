package br.com.TrustHelp.Record.Request;

public record PermissaoRequest(
        int idPermissao,
        String nome,
        String descricaoPermissao
) {}
