package br.com.aula3.tt.gestaoclientes2.dto;

import java.util.List;

public class PedidoDTO {
    private String data;
    private List<ProdutoDTO> produtos;
    private Double total;

    public PedidoDTO() {
    }

    public PedidoDTO(String data, List<ProdutoDTO> produtos, Double total) {
        this.data = data;
        this.produtos = produtos;
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public Double getTotal() {
        return total;
    }
}
