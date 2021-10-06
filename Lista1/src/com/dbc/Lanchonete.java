package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Lanchonete {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        float valorTotal = 0;
        float valorPago = 0;

        System.out.println("Digite o valor Total: ");
        valorTotal = scan.nextFloat();
        System.out.println("Digite o valor Pago: ");
        valorPago = scan.nextFloat();

        System.out.printf(valorPago < valorTotal
                ? "O valor pago deve ser maior ou igual ao valor consumido."
                : "R$%.2f",valorPago - valorTotal);
    }
}
