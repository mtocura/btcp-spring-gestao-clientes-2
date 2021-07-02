package br.com.aula3.tt.gestaoclientes2.model.converter;

import br.com.aula3.tt.gestaoclientes2.dto.PedidoDTO;
import br.com.aula3.tt.gestaoclientes2.form.PedidoForm;
import br.com.aula3.tt.gestaoclientes2.form.ProdutoForm;
import br.com.aula3.tt.gestaoclientes2.model.entity.Pedido;
import br.com.aula3.tt.gestaoclientes2.utils.Id;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoConverter {
    public static Pedido pedidoFormToEntity(PedidoForm pedidoForm) {
        return new Pedido(
                Id.generateIDPedido(),
                today(),
                ProdutoConverter.produtoFormToEntity(pedidoForm.getProdutos()),
                total(pedidoForm.getProdutos())
        );
    }

    public static List<Pedido> pedidoFormToEntity(List<PedidoForm> pedidoForms) {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoForm pedidoForm : pedidoForms) {
            pedidos.add(pedidoFormToEntity(pedidoForm));
        }

        return pedidos;
    }

    public static PedidoDTO pedidoEntityToDTO(Pedido pedido) {
        return new PedidoDTO(
                today(),
                ProdutoConverter.produtoEntityToDTO(pedido.getProdutos()),
                pedido.getTotal()
        );
    }

    public static List<PedidoDTO> pedidoEntityToDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidosDTOS = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidosDTOS.add(pedidoEntityToDTO(pedido));
        }

        return pedidosDTOS;
    }

    private static String today() {
        Calendar calendar = Calendar.getInstance();

        Integer ano = calendar.get(Calendar.YEAR);
        Integer mes = calendar.get(Calendar.MONTH) + 1;
        Integer dia = calendar.get(Calendar.DAY_OF_MONTH);

        return dia + "/" + mes + "/" + ano;
    }

    private static double total(List<ProdutoForm> produtoForms) {
        double total = 0.0;

        for (ProdutoForm produtoForm : produtoForms) {
            total += produtoForm.getPreco() * produtoForm.getQuantidade();
        }

        return total;
    }
}
