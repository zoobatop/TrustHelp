package br.com.TrustHelp.Model.Papel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PapelOutput {

    @JsonProperty("id_papel")
    private Integer idPapel;

    @JsonProperty("pap_nome")
    private String papNome;

    @JsonProperty("pap_descricao")
    private String papDescricao;

    // Construtores
    public PapelOutput() {
    }

    public PapelOutput(Integer idPapel, String papNome, String papDescricao) {
        this.idPapel = idPapel;
        this.papNome = papNome;
        this.papDescricao = papDescricao;
    }

    // Getters e Setters
    public Integer getIdPapel() {
        return idPapel;
    }

    public void setIdPapel(Integer idPapel) {
        this.idPapel = idPapel;
    }

    public String getPapNome() {
        return papNome;
    }

    public void setPapNome(String papNome) {
        this.papNome = papNome;
    }

    public String getPapDescricao() {
        return papDescricao;
    }

    public void setPapDescricao(String papDescricao) {
        this.papDescricao = papDescricao;
    }
}