package br.com.TrustHelp.Record.DTO;

import br.com.TrustHelp.Model.*;

public record EnderecoDTO(
    int idEndereco,
    User idUsuario,
    Organizacao organizacaoId,
    String logadouro,
    String numero,
    String complemento,
    String cep,
    String uf
) { }
