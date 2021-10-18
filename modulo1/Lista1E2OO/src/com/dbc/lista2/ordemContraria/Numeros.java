package com.dbc.lista2.ordemContraria;

import java.util.Locale;
import java.util.Scanner;

public class Numeros {
    private Integer[] numeros;

    public Numeros() {

    }

    public Numeros(Integer tamanho) {
        this.numeros = new Integer[tamanho];
    }

    public Integer[] getNumeros() {
        return numeros;
    }

    public void setNumeros(Integer[] numeros) {
        this.numeros = numeros;
    }

    public void preencherVetor() {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        for (int i = 0; i < this.numeros.length; i++) {
            System.out.println("Digite o " + (i+1) + "°/20° valor: ");
            this.numeros[i] = scan.nextInt();
        }
    }

    public void inverterNumeros() {
        for (int i = 19; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }
}
