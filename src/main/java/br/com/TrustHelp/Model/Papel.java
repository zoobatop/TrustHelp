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
    private int id;
    private TipoPapel tipoPapel;
    private String descricao;
}
