package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Model.Organizacao;
import br.com.TrustHelp.Model.User;

public record EnderecoRequest(
        int idEndereco,
        User idUsuario,
        Organizacao organizacaoId,
        String logadouro,
        String numero,
        String complemento,
        String cep,
        String uf
) { }
