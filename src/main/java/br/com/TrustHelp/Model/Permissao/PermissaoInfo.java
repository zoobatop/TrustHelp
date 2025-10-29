package br.com.TrustHelp.Model.Permissao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissaoInfo {
    private Integer id;
    private String perNome;
    private String perDescricao;

    public PermissaoInfo() {}

    public PermissaoInfo(Integer id, String perNome, String perDescricao) {
        this.id = id;
        this.perNome = perNome;
        this.perDescricao = perDescricao;
    }

}