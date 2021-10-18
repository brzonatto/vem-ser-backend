package com.dbc.lista2.papelaria;

import static com.dbc.utils.Utils.formatarDouble;

public class Caixa {
    private String nomeProduto;
    private Double valorProduto;

    public Caixa() {

    }

    public Caixa(String nomeProduto, Double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void calculaPromocao() {
        System.out.println("Produto: " + this.nomeProduto);
        System.out.printf("Preço " + formatarDouble(this.valorProduto));
        System.out.println("\n-- Promoção --");
        System.out.println("-------------------");

        Double porcentagemPromocao = 0.05;

        for (int i = 0; i < 10; i++) {
            Double valorPromocao = valorProduto - (porcentagemPromocao * valorProduto);
            System.out.println((i + 1) + " x " + formatarDouble(valorPromocao) + " = "
                    + formatarDouble(valorPromocao * (i + 1)));
            porcentagemPromocao += 0.05;
        }
    }
}
