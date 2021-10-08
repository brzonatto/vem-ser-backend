package com.dbc;

public class Contato {
    public String descricao;
    public String telefone;
    public Integer tipo;

    public Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
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


