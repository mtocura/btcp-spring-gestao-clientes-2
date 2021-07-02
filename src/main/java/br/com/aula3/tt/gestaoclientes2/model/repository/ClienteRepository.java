package br.com.aula3.tt.gestaoclientes2.model.repository;

import br.com.aula3.tt.gestaoclientes2.model.entity.Cliente;
import br.com.aula3.tt.gestaoclientes2.model.entity.Pedido;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepository {
    private static final File FILE = new File("clientes.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Cliente> getAll(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {};
            clientes = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public List<Pedido> getPedidosCliente(long id) {
        List<Cliente> clientes = getAll();

        Optional<Cliente> clienteOptional = clientes.stream().filter(cliente -> cliente.getId() == id).findAny();

        if(clienteOptional.isPresent()) {
            return clienteOptional.get().getPedidos();
        }

        return null;
    }

    public List<Pedido> getPedidosData(String data) {
        List<Cliente> clientes = getAll();
        List<Pedido> pedidos = new ArrayList<>();

        for (Cliente cliente : clientes) {
            for (Pedido pedido : cliente.getPedidos()) {
                if(pedido.getData().equals(data)) {
                    pedidos.add(pedido);
                }
            }
        }

        return pedidos;
    }

    public void addCliente(Cliente cliente) {
        try {
            List<Cliente> clientes = getAll();
            clientes.add(cliente);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, clientes);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente) {
        try {
            List<Cliente> clientes = getAll();

            Optional<Cliente> clienteOptional = clientes.stream().filter(c -> c.getId() == cliente.getId()).findFirst();
            List<Cliente> updatedClientes = clientes.stream().filter(c -> c.getId() != cliente.getId()).collect(Collectors.toList());

            if(clienteOptional.isPresent()) {
                clienteOptional.get().setPedidos(cliente.getPedidos());
                updatedClientes.add(clienteOptional.get());
            }

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updatedClientes);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cliente deleteCliente(long id) {
        try {
            List<Cliente> clientes = getAll();

            Optional<Cliente> clienteOptional = clientes.stream().filter(c -> c.getId() == id).findFirst();
            List<Cliente> updateCLientes = clientes.stream().filter(c -> c.getId() != id).collect(Collectors.toList());

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updateCLientes);
            out.close();

            if(clienteOptional.isPresent()) {
                return clienteOptional.get();
            }

            return null;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return null;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
