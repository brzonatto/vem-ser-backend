package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Jogadores {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        String palavra = "";
        int totalJogadores = 0;
        double alturaMaior = 0;
        double pesoMaior = 0;
        String nomePesado = "";
        int idadeMaior = 0;
        String nomeVelho = "";
        double somaAltura = 0;
        double mediaAltura = 0;

        while (!palavra.equalsIgnoreCase("sair")) {
            System.out.println("\nDigite o nome: ");
            String nome = scan.next();
            System.out.println("Digite a altura: ");
            double altura = scan.nextDouble();
            System.out.println("Digite a idade: ");
            int idade = scan.nextInt();
            System.out.println("Digite o peso: ");
            double peso = scan.nextDouble();

            totalJogadores += 1;
            somaAltura += altura;
            if (altura > alturaMaior) {
                alturaMaior = altura;
            }
            if (idade > idadeMaior) {
                idadeMaior = idade;
                nomeVelho = nome;
            }
            if (peso > pesoMaior) {
                pesoMaior = peso;
                nomePesado = nome;
            }

            System.out.println("\nPara encerrar digite (SAIR)\nPara continuar digite (SIM)");
            palavra = scan.next();
        }
        mediaAltura = somaAltura / totalJogadores;
        System.out.printf("Quantidade de jodaores: %d\nAltura do maior jogador: %.2fm\nJogador mais velho: %s com %d anos" +
                "\nJogador mais pesado: %s com %.2fkg\nMédia das altura dos jogadores: %.2fm", totalJogadores, alturaMaior, nomeVelho, idadeMaior, nomePesado, pesoMaior, mediaAltura);
    }
}
