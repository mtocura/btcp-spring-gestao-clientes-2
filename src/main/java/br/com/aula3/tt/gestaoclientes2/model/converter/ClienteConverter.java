package br.com.aula3.tt.gestaoclientes2.model.converter;

import br.com.aula3.tt.gestaoclientes2.dto.ClienteDTO;
import br.com.aula3.tt.gestaoclientes2.form.ClienteForm;
import br.com.aula3.tt.gestaoclientes2.model.entity.Cliente;
import br.com.aula3.tt.gestaoclientes2.utils.Id;

import java.util.ArrayList;
import java.util.List;

public class ClienteConverter {
    public static Cliente clienteFormToEntity(ClienteForm clienteForm) {
        return new Cliente(
                Id.generateIDCliente(),
                clienteForm.getNome(),
                clienteForm.getCpf(),
                clienteForm.getEmail(),
                clienteForm.getTelefone(),
                PedidoConverter.pedidoFormToEntity(clienteForm.getPedidos())
        );
    }

    public static List<Cliente> clienteFormToEntity(List<ClienteForm> clienteForms) {
        List<Cliente> clientes = new ArrayList<>();

        for (ClienteForm clienteForm : clienteForms) {
            clientes.add(clienteFormToEntity(clienteForm));
        }

        return clientes;
    }

    public static ClienteDTO clienteEntityToDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                PedidoConverter.pedidoEntityToDTO(cliente.getPedidos())
        );
    }

    public static List<ClienteDTO> clienteEntityToDTO(List<Cliente> clientes) {
        List<ClienteDTO> clientesDTOS = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clientesDTOS.add(clienteEntityToDTO(cliente));
        }

        return clientesDTOS;
    }
}
