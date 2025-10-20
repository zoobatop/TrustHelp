package br.com.TrustHelp.Record.DTO;

public record EmpresaAtendimentoDTO(
        int id,
        String nome,
        String cnpj,
        String email,
        String telefone
) { }
