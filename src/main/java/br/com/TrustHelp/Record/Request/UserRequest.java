package br.com.TrustHelp.Record.Request;

public record UserRequest(
        Long id,
        String nome,
        String email,
        String senha,
        boolean isAtivo,
        int papelId,
        int organizacaoId
) {}
