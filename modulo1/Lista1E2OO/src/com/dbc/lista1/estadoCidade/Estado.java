package com.dbc.lista1.estadoCidade;

public class Estado {
    private String nome;
    private Cidade[] cidades;

    public Estado() {

    }

    public Estado(String nome, Cidade[] cidades) {
        this.nome = nome;
        this.cidades = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade[] getCidades() {
        return cidades;
    }

    public void setCidade(Cidade[] cidades) {
        this.cidades = cidades;
    }

    public Boolean existeCidade(String nomeCidade) {
        for (int i = 0; i < this.cidades.length; i++) {
            if(this.cidades[i].getNome().equalsIgnoreCase(nomeCidade)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Estado: " + this.nome;
    }
}
