package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        float total, valorExtra50, valorExtra100;
        final float EXTRA_50 = 0.5f;
        final float EXTRA_100 = 1f;

        System.out.println("Digite o valor da hora: ");
        float valorHora = scan.nextFloat();
        System.out.println("Digite o tempo normal de horas trabalhadas: ");
        float tempoNormal = scan.nextFloat();
        System.out.println("Digite o tempo de horas extras (50%) trabalhadas: ");
        float tempoExtra50 = scan.nextFloat();
        System.out.println("Digite o tempo de horas extras (100%) trabalhadas: ");
        float tempoExtra100 = scan.nextFloat();

        valorExtra50 = (EXTRA_50 * valorHora);
        valorExtra100 = (EXTRA_100 * valorHora);

        total = valorHora * tempoNormal;
        total += valorExtra50 * tempoExtra50;
        total += valorExtra100 * tempoExtra100;

        System.out.printf("Salário Bruto: R$%.2f", total);
    }
}
