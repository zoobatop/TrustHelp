package br.com.TrustHelp.Record;

public record UserRequest(
        Long id,
        String nome,
        String senha,
        String email,
        String papelId
) {}
