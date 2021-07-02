package br.com.aula3.tt.gestaoclientes2.model.converter;

import br.com.aula3.tt.gestaoclientes2.dto.ProdutoDTO;
import br.com.aula3.tt.gestaoclientes2.form.ProdutoForm;
import br.com.aula3.tt.gestaoclientes2.model.entity.Produto;
import br.com.aula3.tt.gestaoclientes2.utils.Id;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConverter {
    public static Produto produtoFormToEntity(ProdutoForm produtoForm) {
        return new Produto(
                Id.generateIDProduto(),
                produtoForm.getDescricao(),
                produtoForm.getCor(),
                produtoForm.getQuantidade(),
                produtoForm.getPreco()
        );
    }

    public static List<Produto> produtoFormToEntity(List<ProdutoForm> produtoForms) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoForm produtoForm : produtoForms) {
            produtos.add(produtoFormToEntity(produtoForm));
        }

        return produtos;
    }

    public static ProdutoDTO produtoEntityToDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getDescricao(),
                produto.getCor(),
                produto.getQuantidade(),
                produto.getPreco()
        );
    }

    public static List<ProdutoDTO> produtoEntityToDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtosDTOS = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosDTOS.add(produtoEntityToDTO(produto));
        }

        return produtosDTOS;
    }
}
