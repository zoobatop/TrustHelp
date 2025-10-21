package br.com.TrustHelp.Record.Request;

public record OrganizacaoRequest(
        int organizacaoId,
        String nome,
        String cnpj,
        String email,
        String telefone,
        boolean isAtivo
) { }
