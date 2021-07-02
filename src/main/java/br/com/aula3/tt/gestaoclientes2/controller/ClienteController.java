package br.com.aula3.tt.gestaoclientes2.controller;

import br.com.aula3.tt.gestaoclientes2.dto.ClienteDTO;
import br.com.aula3.tt.gestaoclientes2.dto.PedidoDTO;
import br.com.aula3.tt.gestaoclientes2.form.ClienteForm;
import br.com.aula3.tt.gestaoclientes2.model.entity.Cliente;
import br.com.aula3.tt.gestaoclientes2.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aula3/tt")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController() {
    }

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> getAllClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> getPedidosCliente(@PathVariable long id) {
        List<PedidoDTO> pedidos = clienteService.getPedidosCliente(id);

        if(pedidos == null) return null;

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{dia}/{mes}/{ano}")
    public ResponseEntity<?> getPedidosData(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano) {
        List<PedidoDTO> pedidos = clienteService.getPedidosData(dia, mes, ano);

        if(pedidos == null) return null;

        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> addCliente(@RequestBody ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
        Cliente cliente = clienteService.addCliente(clienteForm);

        URI uri = uriBuilder.path("/aula3/tt/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable long id, @RequestBody ClienteForm clienteForm) {
        clienteService.updateCliene(id, clienteForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable long id) {
        ClienteDTO cliente = clienteService.deleteCliente(id);

        if(cliente == null) return null;

        return ResponseEntity.ok(cliente);
    }
}
