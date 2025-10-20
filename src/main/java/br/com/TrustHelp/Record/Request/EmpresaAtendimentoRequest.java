package br.com.TrustHelp.Record.Request;

public record EmpresaAtendimentoRequest(
        int id,
        String nome,
        String cnpj,
        String email,
        String telefone
) {
}
