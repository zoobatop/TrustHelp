package br.com.TrustHelp.Model;
import br.com.TrustHelp.Enum.TipoTelefone;
import lombok.Builder;

public class Telefone {
    private int id;
    private int userId;
    private String ddd;
    private String numero;
    private TipoTelefone tipoTelefone;
    private boolean isTelefonePrincipal = true;
    private boolean isTelefoneAtivo = true;

    private Telefone(Builder builder) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public boolean isTelefonePrincipal() {
        return isTelefonePrincipal;
    }

    public void setTelefonePrincipal(boolean telefonePrincipal) {
        isTelefonePrincipal = telefonePrincipal;
    }

    public boolean isTelefoneAtivo() {
        return isTelefoneAtivo;
    }

    public void setTelefoneAtivo(boolean telefoneAtivo) {
        isTelefoneAtivo = telefoneAtivo;
    }
}
