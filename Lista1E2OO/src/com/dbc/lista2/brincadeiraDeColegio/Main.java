package com.dbc.lista2.brincadeiraDeColegio;

public class Main {
    public static void main(String[] args) {
        Brincadeira b1 = new Brincadeira(100);
        System.out.println(b1.getNumeroSorteado());

        b1.jogo();
    }
}
