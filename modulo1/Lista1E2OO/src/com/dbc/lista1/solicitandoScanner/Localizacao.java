package com.dbc.lista1.solicitandoScanner;

public class Localizacao {
    private String cidade;
    private String estado;

    public Localizacao() {

    }

    public Localizacao(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "é da cidade de " + this.cidade + ", situada no estado de " + this.estado + ".";
    }
}
