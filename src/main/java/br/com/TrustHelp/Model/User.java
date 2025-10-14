package br.com.TrustHelp.Model;

import lombok.Builder;

@Builder

public class User {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private boolean isActive = true;

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public boolean isActive() { return isActive; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}