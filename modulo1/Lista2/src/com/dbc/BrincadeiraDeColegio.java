package com.dbc;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BrincadeiraDeColegio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        Random gerador = new Random();

        int numero = gerador.nextInt(100);
        System.out.println(numero);
        System.out.println("Tente advinhar o número entre 0 e 100! \n" +
                "Digite seu número: ");
        int numeroEscolhido = scan.nextInt();

        while (numeroEscolhido != numero) {
            if (numeroEscolhido != numero) {
                System.out.println("Que pena, você errou!");
                if (numeroEscolhido < numero) {
                    System.out.println("Tente um número MAIOR!");
                } else {
                    System.out.println("Tente um número MENOR!");
                }
            }
            numeroEscolhido = scan.nextInt();
        }
        System.out.println("Parabéns, você acertou!");
    }
}
