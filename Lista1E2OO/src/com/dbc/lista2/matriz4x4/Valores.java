package com.dbc.lista2.matriz4x4;

import java.util.Locale;
import java.util.Scanner;

public class Valores {
    Integer[][] valores;

    public Valores() {

    }

    public Valores(Integer linha, Integer coluna) {
        this.valores = new Integer[linha][coluna];
    }

    public Integer[][] getValores() {
        return valores;
    }

    public void setValores(Integer[][] valores) {
        this.valores = valores;
    }

    public void preencherMatriz() {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + ", coluna " + (j + 1) + ": ");
                valores[i][j] = scan.nextInt();
            }
        }
    }

    public Integer maiores10() {
        Integer contador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (valores[i][j] > 10) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
