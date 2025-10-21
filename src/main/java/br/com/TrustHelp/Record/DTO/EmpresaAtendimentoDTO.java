package br.com.TrustHelp.Record.DTO;

public record EmpresaAtendimentoDTO(
        int idEmpresa,
        String nome,
        String cnpj,
        String email,
        String telefone
) { }
