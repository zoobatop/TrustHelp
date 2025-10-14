package br.com.TrustHelp.Model;

import br.com.TrustHelp.Enum.TipoPapel;

public class Papel {
    private int id;
    private TipoPapel tipoPapel;
    private String descricao;

    public Papel() {
    }

    public Papel(int id, TipoPapel tipoPapel, String descricao) {
        this.id = id;
        this.tipoPapel = tipoPapel;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoPapel getTipoPapel() {
        return tipoPapel;
    }

    public void setTipoPapel(TipoPapel tipoPapel) {
        this.tipoPapel = tipoPapel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
