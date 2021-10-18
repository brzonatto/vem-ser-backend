package com.dbc;

public class Contato {
    private String descricao;
    private String telefone;
    private Integer tipo;

    public Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato() {
        String tipoNome = "";
        if (this.tipo == 1) {
            tipoNome = "Residêncial";
        } else if (this.tipo == 2) {
            tipoNome = "Comercial";
        }
        System.out.println("Contato Tipo: " + tipoNome + "\n" + this);
    }

    @Override
    public String toString() {
        return this.telefone + " (" + this.descricao + ")";
    }
}
