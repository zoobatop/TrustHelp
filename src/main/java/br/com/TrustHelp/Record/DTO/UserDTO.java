package br.com.TrustHelp.Record.DTO;

import br.com.TrustHelp.Model.Organizacao;
import br.com.TrustHelp.Model.Papel;

public record UserDTO(
        int idUsuario,
        String nome,
        String email,
        String senha,
        boolean isAtivo,
        Papel idPapel,
        Organizacao organizacaoId
) {}
