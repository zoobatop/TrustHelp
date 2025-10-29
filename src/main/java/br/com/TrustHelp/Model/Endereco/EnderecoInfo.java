package br.com.TrustHelp.Model.Endereco;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.User.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInfo {
    private Integer id;
    private Usuario idUsuario;
    private Organizacao idOrganizacao;
    private String endLogradouro;
    private String endNumero;
    private String endComplemento;
    private String endCep;
    private String endUf;
}
