package br.com.TrustHelp.Record.DTO;

public record OrganizacaoDTO(
        int id,
        String nome,
        String cnpj,
        String email,
        String telefone,
        boolean isAtivo
) { }
