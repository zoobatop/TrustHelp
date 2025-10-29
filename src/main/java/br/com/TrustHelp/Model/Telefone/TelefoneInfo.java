package br.com.TrustHelp.Model.Telefone;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TelefoneInfo {
    private Integer id;
    private Integer idUsuario;
    private String nomeUsuario;
    private String telDdd;
    private String telNumero;
    private String telTipo;
    private Boolean telPrincipal;
    private Boolean telAtivo;
    private Instant createdAt;
    private String telefoneFormatado;

    public TelefoneInfo() {}

    public TelefoneInfo(Integer id, Integer idUsuario, String nomeUsuario, String telDdd,
                        String telNumero, String telTipo, Boolean telPrincipal,
                        Boolean telAtivo, Instant createdAt) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.telDdd = telDdd;
        this.telNumero = telNumero;
        this.telTipo = telTipo;
        this.telPrincipal = telPrincipal;
        this.telAtivo = telAtivo;
        this.createdAt = createdAt;
        this.telefoneFormatado = formatarTelefone(telDdd, telNumero);
    }

    private String formatarTelefone(String ddd, String numero) {
        if (numero.length() == 9) {
            return String.format("(%s) %s-%s", ddd, numero.substring(0, 5), numero.substring(5));
        } else if (numero.length() == 8) {
            return String.format("(%s) %s-%s", ddd, numero.substring(0, 4), numero.substring(4));
        }
        return String.format("(%s) %s", ddd, numero);
    }
}