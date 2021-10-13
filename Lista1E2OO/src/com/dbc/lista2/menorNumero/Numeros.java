package com.dbc.lista2.menorNumero;

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
            System.out.println("Digite o " + (i+1) + "° número: ");
            this.numeros[i] = scan.nextInt();
        }
    }

    public void encontrarMenorNumero() {
        Integer menor = numeros[0];
        Integer posicao = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
                posicao = i;
            }
        }
        System.out.println("O menor número é " + menor + " no indice " + posicao);
    }
}
