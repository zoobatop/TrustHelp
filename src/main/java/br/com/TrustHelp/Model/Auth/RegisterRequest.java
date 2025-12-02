package br.com.TrustHelp.Model.Auth;

public class RegisterRequest {
    
    private String nome;
    private String email;
    private String senha;
    private String confirmarSenha;
    private Integer idPapel;
    private Integer idOrganizacao;
    
    // Construtores
    public RegisterRequest() {}
    
    public RegisterRequest(String nome, String email, String senha, String confirmarSenha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getConfirmarSenha() {
        return confirmarSenha;
    }
    
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    public Integer getIdPapel() {
        return idPapel;
    }
    
    public void setIdPapel(Integer idPapel) {
        this.idPapel = idPapel;
    }
    
    public Integer getIdOrganizacao() {
        return idOrganizacao;
    }
    
    public void setIdOrganizacao(Integer idOrganizacao) {
        this.idOrganizacao = idOrganizacao;
    }
    
    // Método de validação
    public boolean isValid() {
        return nome != null && !nome.trim().isEmpty() &&
               email != null && !email.trim().isEmpty() &&
               senha != null && !senha.trim().isEmpty() &&
               confirmarSenha != null && !confirmarSenha.trim().isEmpty() &&
               senha.equals(confirmarSenha);
    }
}