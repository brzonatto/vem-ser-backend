package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Matriz4x4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        int[][] valores = new int[4][4];
        int contador = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + ", coluna " + (j + 1) + ": ");
                valores[i][j] = scan.nextInt();
                if (valores[i][j] > 10) {
                    contador++;
                }
            }
        }
        System.out.println("O vetor possui " + contador + " valores maiores que 10!");
    }
}
