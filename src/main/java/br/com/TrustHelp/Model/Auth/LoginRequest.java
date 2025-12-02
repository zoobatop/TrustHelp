package br.com.TrustHelp.Model.Auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String email;
    private String senha;

    public LoginRequest() {
    }

    public LoginRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
