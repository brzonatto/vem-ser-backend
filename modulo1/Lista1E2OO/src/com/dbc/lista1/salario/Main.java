package com.dbc.lista1.salario;

//        Crie um programa que calcule o salário do usuário, para isso será necessário passar o valor da hora em R$,
//        o número de horas normais trabalhas, as horas extras (50%), e as horas extras trabalhadas (100%), em
//        seguida exiba o salário bruto.

public class Main {
    public static void main(String[] args) {
        Salario s1 = new Salario(20.00,170,5,5);

        System.out.println(s1);
    }
}
