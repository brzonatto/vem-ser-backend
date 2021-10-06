package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        float notas[] = new float[4];
        float soma = 0;
        float media;
        String message = "";

        for (int i = 0; i < 4; i++) {
            System.out.println("Digite a " + (i+1) + "ª nota: ");
            notas[i] = scan.nextFloat();
            soma += notas[i];
        }

        media = soma / 4;

        if (media <= 5) {
            message = "reprovado!";
        } else if (media <= 6.9 && media >= 5.1) {
            message = "em exame!";
        } else {
            message = "aprovado!";
        }

        System.out.println("Nota: " + media + ", portanto, " + message);
    }
}