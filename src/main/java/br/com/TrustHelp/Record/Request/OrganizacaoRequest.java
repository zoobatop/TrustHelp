package br.com.TrustHelp.Record.Request;

public record OrganizacaoRequest(
        int id,
        String nome,
        String cnpj,
        String email,
        String telefone,
        boolean isAtivo
) { }
