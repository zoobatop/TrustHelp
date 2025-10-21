package br.com.TrustHelp.Record.Request;

public record EmpresaAtendimentoRequest(
        int idEmpresa,
        String nome,
        String cnpj,
        String email,
        String telefone
) { }
