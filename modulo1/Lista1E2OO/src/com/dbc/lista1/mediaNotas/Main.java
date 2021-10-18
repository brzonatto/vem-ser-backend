package com.dbc.lista1.mediaNotas;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        Double[] notas = new Double[4];

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a " + (i+1) + "ª nota: ");
            notas[i] = scan.nextDouble();
        }

        Notas n1 = new Notas(notas);

        System.out.println(n1);
    }
}
