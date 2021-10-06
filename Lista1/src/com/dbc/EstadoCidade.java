package com.dbc;

import java.util.Scanner;

public class EstadoCidade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha um estado entre RS, SC e PR:");
        String escolha = scan.nextLine();


        switch (escolha) {
            case "RS":
                System.out.println("Escolha um estado entre Porto Alegre e Triunfo");
                escolha = scan.nextLine();
                if (escolha.equalsIgnoreCase("Porto Alegre")) {
                    System.out.println("População: 1492530");
                    System.out.println("Prefeito: Sebastião Melo");
                    System.out.println("Área: 496682 km²");
                    System.out.println("IDH: 0,805");
                } else if (escolha.equalsIgnoreCase("Triunfo")) {
                    System.out.println("População: 23311");
                    System.out.println("Prefeito: Murilo Machado");
                    System.out.println("Área: 823416 km²");
                    System.out.println("IDH: 0,788");
                } else {
                    System.out.println("Cidade inválida!");
                }
                break;
            case "SC":
                System.out.println("Escolha um estado entre Florianopolis e Itajai");
                escolha = scan.nextLine();
                if (escolha.equalsIgnoreCase("Florianopolis")) {
                    System.out.println("População: 516524");
                    System.out.println("Prefeito: Gean Loureiro");
                    System.out.println("Área: 675409 km²");
                    System.out.println("IDH: 0,847");
                } else if (escolha.equalsIgnoreCase("Itajai")) {
                    System.out.println("População: 223112");
                    System.out.println("Prefeito: Volnei José Morastoni");
                    System.out.println("Área: 289255 km²");
                    System.out.println("IDH: 0,795");
                } else {
                    System.out.println("Cidade inválida!");
                }
                break;
            case "PR":
                System.out.println("Escolha uma ciade entre Curitiba e Londrina");
                escolha = scan.nextLine();
                if (escolha.equalsIgnoreCase("Curitiba")) {
                    System.out.println("População: 1963726");
                    System.out.println("Prefeito: Rafael Greca");
                    System.out.println("Área: 435036 km²");
                    System.out.println("IDH: 0,823");
                } else if (escolha.equalsIgnoreCase("Londrina")) {
                    System.out.println("População: 580870");
                    System.out.println("Prefeito: Marcelo Belinati Martins");
                    System.out.println("Área: 1652569 km²");
                    System.out.println("IDH: 0,778");
                } else {
                    System.out.println("Cidade inválida!");
                }
                break;
            default:
                System.out.println("Estado inválido!");
                break;
        }
    }
}
