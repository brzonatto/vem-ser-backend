package com.dbc.lista1.tradutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Palavra p1 = new Palavra("cachorro", "dog");
        Palavra p2 = new Palavra("tempo", "time");
        Palavra p3 = new Palavra("amor", "love");
        Palavra p4 = new Palavra("cidade", "city");
        Palavra p5 = new Palavra("feliz", "happy");

        Palavra[] palavras = {p1, p2, p3, p4, p5};

        Cadastro cadastro = new Cadastro(palavras);

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma palavra para ser traduzida (pt-Br ou eng): ");
        String palavra = scan.next();

        System.out.println(cadastro.traduzir(palavra));
    }
}
