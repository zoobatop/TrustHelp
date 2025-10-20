package br.com.TrustHelp.Record.DTO;

public record EnderecoDTO(
    int id,
    int usuarioId,
    int organizacaoId,
    String logadouro,
    String numero,
    String complemento,
    String cep,
    String uf
) { }
