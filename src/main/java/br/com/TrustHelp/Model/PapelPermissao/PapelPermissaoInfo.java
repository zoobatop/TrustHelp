package br.com.TrustHelp.Model.PapelPermissao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PapelPermissaoInfo {
    private Integer idPapel;
    private Integer idPermissao;
    private String nomePapel;
    private String nomePermissao;
}
