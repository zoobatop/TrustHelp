package br.com.TrustHelp.Model.ParametroConfiguracao;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ParametroConfiguracaoInfo {
    private Integer id;
    private String parChave;
    private String parValor;
    private String parCategoria;
    private String parDescricao;
    private Boolean parAtivo;
    private Instant parAtualizadoEm;

    public ParametroConfiguracaoInfo() {}

    public ParametroConfiguracaoInfo(Integer id, String parChave, String parValor, String parCategoria,
                                     String parDescricao, Boolean parAtivo, Instant parAtualizadoEm) {
        this.id = id;
        this.parChave = parChave;
        this.parValor = parValor;
        this.parCategoria = parCategoria;
        this.parDescricao = parDescricao;
        this.parAtivo = parAtivo;
        this.parAtualizadoEm = parAtualizadoEm;
    }

}