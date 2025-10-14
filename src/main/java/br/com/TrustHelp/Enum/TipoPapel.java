package br.com.TrustHelp.Enum;

import lombok.Getter;

@Getter
public enum TipoPapel {
    ADMIN("admin"),
    ANALISTA("analista"),
    CLIENTE("cliente");

    private final String tipoPapel;
    TipoPapel(String tipoPapel) {
        this.tipoPapel = tipoPapel;
    }
}
