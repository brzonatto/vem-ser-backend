package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Papelaria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = scan.next();
        System.out.println("Digite o valor do produto: ");
        double valorProduto = scan.nextDouble();
        double porcentagemPromocao = 0.05;
        double valorPromocao;


        System.out.println("Produto: " + nomeProduto);
        System.out.printf("Preço: R$%.2f", valorProduto);
        System.out.println("\n-- Promoção --");
        System.out.println("-------------------");

        for (int i = 0; i < 10; i++) {
            valorPromocao = valorProduto - (porcentagemPromocao * valorProduto);
            System.out.printf("%d x R$%.2f = R$%.2f\n", i + 1, valorPromocao, valorPromocao * (i + 1));
            porcentagemPromocao += 0.05;
        }
    }
}
