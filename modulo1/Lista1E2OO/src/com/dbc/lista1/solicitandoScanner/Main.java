package com.dbc.lista1.solicitandoScanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite sua idade: ");
        int idade = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite sua cidade: ");
        String cidade = scan.nextLine();
        System.out.println("Digite seu estado: ");
        String estado = scan.nextLine();

        Pessoa p1 = new Pessoa(nome, idade, new Localizacao(cidade, estado));

        System.out.println(p1);
    }
}
