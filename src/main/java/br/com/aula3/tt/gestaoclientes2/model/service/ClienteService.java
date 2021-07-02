package br.com.aula3.tt.gestaoclientes2.model.service;

import br.com.aula3.tt.gestaoclientes2.dto.ClienteDTO;
import br.com.aula3.tt.gestaoclientes2.dto.PedidoDTO;
import br.com.aula3.tt.gestaoclientes2.form.ClienteForm;
import br.com.aula3.tt.gestaoclientes2.model.converter.ClienteConverter;
import br.com.aula3.tt.gestaoclientes2.model.converter.PedidoConverter;
import br.com.aula3.tt.gestaoclientes2.model.entity.Cliente;
import br.com.aula3.tt.gestaoclientes2.model.entity.Pedido;
import br.com.aula3.tt.gestaoclientes2.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService() {
    }

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> findAll() {
        return ClienteConverter.clienteEntityToDTO(clienteRepository.getAll());
    }

    public List<PedidoDTO> getPedidosCliente(long id) {
        List<Pedido> pedidos = clienteRepository.getPedidosCliente(id);

        if(pedidos == null) {
            return null;
        }

        return PedidoConverter.pedidoEntityToDTO(pedidos);
    }

    public List<PedidoDTO> getPedidosData(String dia, String mes, String ano) {
        String data = dia + "/" + mes + "/" + ano;
        List<Pedido> pedidos = clienteRepository.getPedidosData(data);

        if(pedidos == null) {
            return null;
        }

        return PedidoConverter.pedidoEntityToDTO(pedidos);
    }

    public Cliente addCliente(ClienteForm clienteForm) {
        Cliente cliente = ClienteConverter.clienteFormToEntity(clienteForm);
        clienteRepository.addCliente(cliente);
        return cliente;
    }

    public void updateCliene(long id, ClienteForm clienteForm) {
        Cliente cliente = ClienteConverter.clienteFormToEntity(clienteForm, id);
        clienteRepository.updateCliente(cliente);
    }

    public ClienteDTO deleteCliente(long id) {
        Cliente cliente = clienteRepository.deleteCliente(id);

        if(cliente == null) return null;

        return ClienteConverter.clienteEntityToDTO(cliente);
    }
}
