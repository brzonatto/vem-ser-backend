package com.dbc;

public class Endereco {
    public Integer tipo;
    public String logradouro;
    public Integer numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(Integer tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco() {
        String tipoNome = "";
        if (this.tipo == 1) {
            tipoNome = "Residêncial";
        } else if (this.tipo == 2) {
            tipoNome = "Comercial";
        }
        System.out.println("Endereço Tipo: " + tipoNome + "\n" + this.toString());
    }

    @Override
    public String toString() {
        return this.logradouro + ", " + this.numero + ", " + this.complemento + ", " + this.cep + " - " + this.cidade
            + "-" + this.estado + " - " + this.pais;
    }

}



