package br.com.TrustHelp.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PapelPermissao {
    Papel idPapel;
    Permissao idPermissao;
}
