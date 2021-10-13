package com.dbc.lista2.matriz4x4;

public class Main {
    public static void main(String[] args) {
        Valores v1 = new Valores(4, 4);
        v1.preencherMatriz();
        System.out.println(v1.maiores10());
    }
}
