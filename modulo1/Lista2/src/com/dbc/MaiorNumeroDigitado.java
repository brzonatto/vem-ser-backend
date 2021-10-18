package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class MaiorNumeroDigitado {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        int[] numeros = new int[3];
        int menor;
        int posicao = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i+1) + "° número: ");
            numeros[i] = scan.nextInt();
        }

        menor = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
                posicao = i;
            }
        }
        System.out.println("O menor número é " + menor + " no indice " + posicao);
    }
}
