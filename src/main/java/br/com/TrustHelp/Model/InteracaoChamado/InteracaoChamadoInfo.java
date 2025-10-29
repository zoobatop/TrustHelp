package br.com.TrustHelp.Model.InteracaoChamado;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InteracaoChamadoInfo {
    private Integer id;
    private Integer idChamado;
    private Integer idUsuario;
    private String nomeUsuario;
    private String intMensagem;
    private String intUrlAnexo;
    private Instant intCriadoEm;

    public InteracaoChamadoInfo() {}

    public InteracaoChamadoInfo(Integer id, Integer idChamado, Integer idUsuario, String nomeUsuario,
                                String intMensagem, String intUrlAnexo, Instant intCriadoEm) {
        this.id = id;
        this.idChamado = idChamado;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.intMensagem = intMensagem;
        this.intUrlAnexo = intUrlAnexo;
        this.intCriadoEm = intCriadoEm;
    }
}