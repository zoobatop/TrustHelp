package br.com.TrustHelp.Model;

import br.com.TrustHelp.Enum.StatusChamado;
import br.com.TrustHelp.Enum.PrioridadeChamado;
import lombok.Builder;

@Builder
public class Chamado {
    private int id;
    private String titulo;
    private String descricao;
    private int organizacaoId;
    private int usuarioAberturaId;
    private int usuarioAtribuidoId;
    private StatusChamado status;
    private PrioridadeChamado prioridade;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getOrganizacaoId() {
        return organizacaoId;
    }

    public int getUsuarioAberturaId() {
        return usuarioAberturaId;
    }

    public int getUsuarioAtribuidoId() {
        return usuarioAtribuidoId;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public PrioridadeChamado getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", prioridade=" + prioridade +
                '}';
    }
}