package br.com.TrustHelp.Model;

import lombok.Builder;

@Builder
public class Organizacao {
    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private boolean isAtivo = true;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    @Override
    public String toString() {
        return "Organizacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", isAtivo=" + isAtivo +
                '}';
    }
}
