package com.dbc.lista1.solicitandoScanner;

public class Pessoa {
    private String nome;
    private Integer idade;
    private Localizacao localizacao;

    public Pessoa() {

    }

    public Pessoa(String nome, Integer idade, Localizacao localizacao) {
        this.nome = nome;
        this.idade = idade;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Olá seu nome é " + this.nome + ", você tem " + this.idade + " anos, " + this.localizacao;
    }
}
