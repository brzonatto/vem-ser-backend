package com.dbc;

public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos;
    public Endereco[] enderecos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        contatos = new Contato[2];
        enderecos = new Endereco[2];
    }

    public void imprimirContatos() {
        for (Contato key : contatos) {
            key.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco key : enderecos) {
            key.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println(this);
        System.out.println("------------------------------");
        this.imprimirEnderecos();
        System.out.println("------------------------------");
        this.imprimirContatos();
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", CPF: " + cpf;
    }
}
