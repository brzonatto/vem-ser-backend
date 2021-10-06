package com.dbc;

import java.util.Scanner;

public class Tradutor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um palavra: ");
        String palavra = scan.nextLine();

        switch (palavra) {
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Tempo":
                System.out.println("Time");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "love":
                System.out.println("Amor");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            default:
                System.out.println("Essa palavra não é válida!");
                break;
        }
    }
}
