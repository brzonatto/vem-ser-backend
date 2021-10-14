package com.dbc;

public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos;
    private Endereco[] enderecos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = new Contato[2];
        this.enderecos = new Endereco[2];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        for (Contato key : contatos) {
            if (key != null) {
                key.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (Endereco key : enderecos) {
            if (key != null) {
                key.imprimirEndereco();
            }
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
