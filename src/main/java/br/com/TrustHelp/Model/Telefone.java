package br.com.TrustHelp.Model;
import br.com.TrustHelp.Enum.TipoTelefone;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Telefone {
    private int idTelefone;
    private User id;
    private String ddd;
    private String numero;
    private TipoTelefone tipoTelefone;
    private boolean isTelefonePrincipal = true;
    private boolean isTelefoneAtivo = true;
}
