package com.dbc.lista1.estadoCidade;

public class Cidade {
    private String nome;
    private Integer populacao;
    private String prefeito;
    private Integer area;
    private Double idh;

    public Cidade() {

    }

    public Cidade(String nome, Integer populacao, String prefeito, Integer area, Double idh) {
        this.nome = nome;
        this.populacao = populacao;
        this.prefeito = prefeito;
        this.area = area;
        this.idh = idh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public String getPrefeito() {
        return prefeito;
    }

    public void setPrefeito(String prefeito) {
        this.prefeito = prefeito;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getIdh() {
        return idh;
    }

    public void setIdh(Double idh) {
        this.idh = idh;
    }

    @Override
    public String toString() {
        return "\nCidade: " + this.nome + "\nPopulação: " + this.populacao + "\nPrefeito: " + this.prefeito
                    + "\nÁrea: " + this.area + "\nIDH: " + this.idh;
    }
}
