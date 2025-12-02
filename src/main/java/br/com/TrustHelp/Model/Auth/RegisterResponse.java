package br.com.TrustHelp.Model.Auth;

import br.com.TrustHelp.Model.User.UsuarioInfo;

public class RegisterResponse {

    private boolean sucesso;
    private String mensagem;
    private UsuarioInfo usuario;
    private String token;

    // Construtores
    public RegisterResponse() {
    }

    public RegisterResponse(boolean sucesso, String mensagem) {
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

    public UsuarioInfo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioInfo usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}