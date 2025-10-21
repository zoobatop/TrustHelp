package br.com.TrustHelp.Model;

import br.com.TrustHelp.Enum.TipoPapel;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Papel {
    private int idPapel;
    private TipoPapel tipoPapel;
    private String descricaoPapel;
}
