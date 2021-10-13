package com.dbc.lista2.encontrarValor;

import com.dbc.utils.Utils;

import java.util.Locale;
import java.util.Scanner;

public class Valores {
    private Integer[] valores;

    public Valores() {

    }

    public Valores(Integer tamanho) {
        this.valores = new Integer[tamanho];
    }

    public Integer[] getValores() {
        return valores;
    }

    public void setValores(Integer[] valores) {
        this.valores = valores;
    }

    public void preencerValores() {
        for (int i = 0; i < this.valores.length; i++) {
            this.valores[i] = Utils.sortearNumero(100);
        }
    }

    public Boolean existeValor(Integer valor) {
        for (int i = 0; i < this.valores.length; i++) {
            if (this.valores[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public void encontrarValor() {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        System.out.println("Digite o valor: ");
        Integer valor = scan.nextInt();

        if (existeValor(valor)) {
            for (int i = 0; i < this.valores.length; i++){
                if (this.valores[i] == valor){
                    System.out.println("Número encontrado no índice: " + i);
                    break;
                }
            }
        } else {
            System.out.println("Valor não encontrado no vetor!");
        }

    }

    public void imprimeVetor() {
        for (Integer key : this.valores) {
            System.out.println(key);
        }
    }
}
