package br.com.TrustHelp.Model.Organizacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizacaoInfo {
    private Integer id;
    private String orgNome;
    private String orgCnpj;
    private String orgEmail;
    private String orgTelefone;
    private Boolean orgAtivo;
}
