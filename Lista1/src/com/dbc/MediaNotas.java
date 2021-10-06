package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        float[] notes = new float[4];
        float soma = 0;
        float media;
        String message;

        for (int i = 0; i < notes.length; i++) {
            System.out.println("Digite a " + (i+1) + "ª nota: ");
            notes[i] = scan.nextFloat();
            soma += notes[i];
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

    public static class Salario {
    }
}