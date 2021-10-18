package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class OrdemContraria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        int[] valores = new int[20];

        for (int i = 0; i < valores.length; i++) {
            System.out.println("Digite o " + (i+1) + "°/20° valor: ");
            valores[i] = scan.nextInt();
        }

        for (int i = 19; i >= 0; i--) {
            System.out.println(valores[i]);
        }
    }
}
