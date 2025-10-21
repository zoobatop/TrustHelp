package br.com.TrustHelp.Record.DTO;

import br.com.TrustHelp.Model.*;

public record InteracaoChamadoDTO(
    int idInteracao,
    Chamado idChamado,
    User idUsuario,
    String mensagem,
    String urlAnexo
) { }
