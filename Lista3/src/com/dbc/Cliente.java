package com.dbc;

public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos;
    public Endereco[] enderecos;

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {

    }

    public void imprimirEnderecos() {

    }

    public void imprimirCliente() {

    }
}
