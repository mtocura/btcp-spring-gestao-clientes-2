package br.com.aula3.tt.gestaoclientes2.dto;

import java.util.List;

public class ClienteDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<PedidoDTO> pedidos;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String cpf, String email, String telefone, List<PedidoDTO> pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }
}
