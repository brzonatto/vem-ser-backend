package com.dbc.lista2.jogadores;

public class Jogador {
    private String nome;
    private Double altura;
    private Integer idade;
    private Double peso;

    public Jogador() {

    }

    public Jogador(String nome, Double altura, Integer idade, Double peso) {
        this.nome = nome;
        this.altura = altura;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nIdade: " + this.idade + "\nAltura: " + this. altura
                + "\nPeso: " + this.peso;
    }
}
