package br.com.TrustHelp.Record.DTO;

public record UserDTO(
        Long id,
        String nome,
        String email,
        String senha,
        boolean isAtivo,
        int papelId,
        int organizacaoId
) {}
