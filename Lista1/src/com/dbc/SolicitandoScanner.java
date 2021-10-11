package com.dbc;

import java.util.Scanner;

public class SolicitandoScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scan.next();
        System.out.println("Digite sua idade: ");
        int idade = scan.nextInt();		
        System.out.println("Digite sua cidade: ");
        String cidade = scan.next();
        System.out.println("Digite seu estado: ");
        String estado = scan.next();

        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada " +
                "no estado de " + estado +".");

    }
}