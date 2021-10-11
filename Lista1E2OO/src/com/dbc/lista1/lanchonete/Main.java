package com.dbc.lista1.lanchonete;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.println("Digite o valor Total: ");
        Double valorTotal = scan.nextDouble();
        System.out.println("Digite o valor Pago: ");
        Double valorPago = scan.nextDouble();

        Caixa c1 = new Caixa();

        System.out.println(c1.calcularTroco(valorTotal,valorPago));

    }
}
