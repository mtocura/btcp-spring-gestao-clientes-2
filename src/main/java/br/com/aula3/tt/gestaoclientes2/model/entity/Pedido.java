package br.com.aula3.tt.gestaoclientes2.model.entity;

import java.util.List;

public class Pedido {
    private Long id;
    private String data;
    private List<Produto> produtos;
    private Double total;

    public Pedido() {
    }

    public Pedido(Long id, String data, List<Produto> produtos, Double total) {
        this.id = id;
        this.data = data;
        this.produtos = produtos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Double getTotal() {
        return total;
    }
}
