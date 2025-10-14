package br.com.TrustHelp.Model;

public class InteracaoChamado {
    private int id;
    private int chamadoId;
    private int usuarioId;
    private String mensagem;
    private String urlAnexo;

    public InteracaoChamado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChamadoId() {
        return chamadoId;
    }

    public void setChamadoId(int chamadoId) {
        this.chamadoId = chamadoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getUrlAnexo() {
        return urlAnexo;
    }

    public void setUrlAnexo(String urlAnexo) {
        this.urlAnexo = urlAnexo;
    }
}