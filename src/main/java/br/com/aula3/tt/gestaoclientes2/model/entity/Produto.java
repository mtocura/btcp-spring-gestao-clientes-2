package br.com.aula3.tt.gestaoclientes2.model.entity;

public class Produto {
    private Long id;
    private String descricao;
    private String cor;
    private Integer quantidade;
    private Double preco;

    public Produto() {
    }

    public Produto(Long id, String descricao, String cor, Integer quantidade, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCor() {
        return cor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }
}
