package com.dbc.lista1.estadoCidade;

public class Estado {
    private String nome;
    private Cidade[] cidade;

    public Estado() {

    }

    public Estado(String nome, Cidade[] cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade[] getCidade() {
        return cidade;
    }

    public void setCidade(Cidade[] cidade) {
        this.cidade = cidade;
    }
}
