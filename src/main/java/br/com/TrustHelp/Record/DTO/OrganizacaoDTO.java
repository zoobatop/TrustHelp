package br.com.TrustHelp.Record.DTO;

public record OrganizacaoDTO(
        int organizacaoId,
        String nome,
        String cnpj,
        String email,
        String telefone,
        boolean isAtivo
) { }
