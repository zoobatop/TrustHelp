package br.com.TrustHelp.Record.Request;

import br.com.TrustHelp.Model.Organizacao;
import br.com.TrustHelp.Model.Papel;

public record UserRequest(
        int idUsuario,
        String nome,
        String email,
        String senha,
        boolean isAtivo,
        Papel idPapel,
        Organizacao organizacaoId
) {}
