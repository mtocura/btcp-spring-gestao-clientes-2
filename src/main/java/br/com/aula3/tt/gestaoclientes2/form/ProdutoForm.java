package br.com.aula3.tt.gestaoclientes2.form;

public class ProdutoForm {
    private String descricao;
    private String cor;
    private Integer quantidade;
    private Double preco;

    public ProdutoForm() {
    }

    public ProdutoForm(String descricao, String cor, Integer quantidade, Double preco) {
        this.descricao = descricao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.preco = preco;
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
