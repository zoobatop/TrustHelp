package br.com.TrustHelp.Model.EmpresaAtendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaAtendimentoInfo {
    private Integer id;
    private String empNome;
    private String empCnpj;
    private String empEmail;
    private String empTelefone;
}
