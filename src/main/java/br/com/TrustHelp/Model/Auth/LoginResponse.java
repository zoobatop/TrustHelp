package br.com.TrustHelp.Model.Auth;

import br.com.TrustHelp.Model.User.UsuarioInfo;
import java.util.Date;

public class LoginResponse {

    private boolean sucesso;
    private String mensagem;
    private String token;
    private UsuarioInfo usuario;
    private Date expiraEm;
    
    public LoginResponse() {
    }

    public LoginResponse(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    // Getters e Setters
    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioInfo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioInfo usuario) {
        this.usuario = usuario;
    }

    public Date getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(Date expiraEm) {
        this.expiraEm = expiraEm;
    }
}