package br.com.aula3.tt.gestaoclientes2.form;

import java.util.List;

public class ClienteForm {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<PedidoForm> pedidos;

    public ClienteForm() {
    }

    public ClienteForm(String nome, String cpf, String email, String telefone, List<PedidoForm> pedidos) {
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

    public List<PedidoForm> getPedidos() {
        return pedidos;
    }
}
