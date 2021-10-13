package com.dbc.lista2.jogadores;

import java.util.Locale;
import java.util.Scanner;

public class Cadastro {
    Jogador[] jogadores = new Jogador[50];
    private Integer totalJogadores = 0;
    Scanner scan = new Scanner(System.in);

    public void addTeste() {
        this.jogadores[this.totalJogadores] = new Jogador("Brunno", 1.81, 29, 84.0);
        this.totalJogadores++;
        this.jogadores[this.totalJogadores] = new Jogador("João", 1.96, 30, 80.0);
        this.totalJogadores++;
        this.jogadores[this.totalJogadores] = new Jogador("Rafael", 1.95, 28, 90.0);
        this.totalJogadores++;
        this.jogadores[this.totalJogadores] = new Jogador("Jonas", 1.89, 23, 88.0);
        this.totalJogadores++;
    }

    public void inserirJogador() {
        scan.useLocale(Locale.US);

        System.out.println("\nDigite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite a altura: ");
        Double altura = scan.nextDouble();
        scan.nextLine();
        System.out.println("Digite a idade: ");
        int idade = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o peso: ");
        double peso = scan.nextDouble();
        scan.nextLine();

        this.jogadores[this.totalJogadores] = new Jogador(nome, altura, idade, peso);
        this.totalJogadores++;
    }

    public void rodaCadastro() {
        String palavra = "";
        while (!palavra.equalsIgnoreCase("sair")) {
            this.inserirJogador();
            System.out.println("\nPara encerrar digite (SAIR)\nPara continuar digite (SIM)");
            palavra = scan.nextLine();

        }
    }

    public Integer quantidadeJogadores() {
        return this.totalJogadores;
    }

    public Double alturaMaior() {
        Double alturaMaior = Double.MIN_VALUE;
        for (int i = 0; i < this.jogadores.length; i++) {
            if (this.jogadores[i] != null) {
                if (this.jogadores[i].getAltura() > alturaMaior) {
                    alturaMaior = this.jogadores[i].getAltura();
                }
            }
        }
        return alturaMaior;
    }

    public String pesoMaior() {
        Double pesoMaior = Double.MIN_VALUE;
        String nomeMaisPesado = "";
        for (int i = 0; i < this.jogadores.length; i++) {
            if (this.jogadores[i] != null) {
                if (this.jogadores[i].getPeso() > pesoMaior) {
                    pesoMaior = this.jogadores[i].getPeso();
                    nomeMaisPesado = this.jogadores[i].getNome();
                }
            }
        }
        return nomeMaisPesado;
    }

    public String idadeMaior() {
        Integer idadeMaior = Integer.MIN_VALUE;
        String nomeMaisVelho = "";
        for (int i = 0; i < this.jogadores.length; i++) {
            if (this.jogadores[i] != null) {
                if (this.jogadores[i].getIdade() > idadeMaior) {
                    idadeMaior = this.jogadores[i].getIdade();
                    nomeMaisVelho = this.jogadores[i].getNome();
                }
            }
        }
        return nomeMaisVelho;
    }

    public Double mediaAlturas() {
        Double somaAlturas = 0.0;
        for (int i = 0; i < this.jogadores.length; i++) {
            if (this.jogadores[i] != null) {
                somaAlturas += this.jogadores[i].getAltura();
            }
        }
        return somaAlturas / this.totalJogadores;
    }

    public void imprimeJogadores() {
        for (Jogador key: this.jogadores) {
            if (key != null) {
                System.out.println("-------------------------");
                System.out.println(key);
            }
        }
    }
}
