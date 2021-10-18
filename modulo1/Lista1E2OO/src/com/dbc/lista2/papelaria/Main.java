package com.dbc.lista2.papelaria;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.println("Digite o nome do produto: ");
        String nome = scan.nextLine();
        System.out.println("Digite o valor do produto: ");
        Double valor = scan.nextDouble();

        Caixa caixa = new Caixa(nome, valor);

        caixa.calculaPromocao();
    }
}
