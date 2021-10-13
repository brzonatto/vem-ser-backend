package com.dbc.lista2.jogadores;

public class Main {
    public static void main(String[] args) {
        Cadastro c1 = new Cadastro();
//        c1.rodaCadastro();
        c1.addTeste();
        System.out.println(c1.quantidadeJogadores());
        System.out.println(c1.alturaMaior());
        System.out.println(c1.idadeMaior());
        System.out.println(c1.pesoMaior());
        System.out.println(c1.mediaAlturas());
        c1.imprimeJogadores();
    }
}
