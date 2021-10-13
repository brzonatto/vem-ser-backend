package com.dbc.lista2.brincadeiraDeColegio;

import com.dbc.utils.Utils;

import java.util.Locale;
import java.util.Scanner;

public class Brincadeira {
    private Integer numeroSorteado;
    private Integer distancia;

    public Brincadeira(Integer numero) {
        this.numeroSorteado = Utils.sortearNumero(numero);
        this.distancia = numero;
    }

    public Integer getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(Integer numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public void jogo() {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.println("Tente advinhar o número entre 0 e " + this.distancia + "! \n" +
                "Digite seu número: ");
        Integer numeroEscolhido = scan.nextInt();

        while (numeroEscolhido != this.numeroSorteado) {
            if (numeroEscolhido != this.numeroSorteado) {
                System.out.println("Que pena, você errou!");
                if (numeroEscolhido < this.numeroSorteado) {
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
