package br.com.TrustHelp.Record.Request;

public record EnderecoRequest(
        int id,
        int usuarioId,
        int organizacaoId,
        String logadouro,
        String numero,
        String complemento,
        String cep,
        String uf
) {
}
