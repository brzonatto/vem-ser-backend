package com.dbc.lista1.estadoCidade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estado e1 = new Estado("Rio Grande do Sul", new Cidade[] {
                new Cidade("Porto Alegre", 1492530, "Sebastião Melo", 496682, 0.805),
                new Cidade("Triunfo", 23311, "Murilo Machado", 823416, 0.788)});
        Estado e2 = new Estado("Santa Catarina", new Cidade[] {
                new Cidade("Florianópolis", 516524, "Gean Loureiro", 675409, 0.847),
                new Cidade("Itajaí", 223112, "Volnei José Morastoni", 289255, 0.795)});
        Estado e3 = new Estado("Paraná", new Cidade[] {
                new Cidade("Curitiba", 1963726, "Rafael Greca", 435036, 0.823),
                new Cidade("Londrina", 580870, "Marcelo Belinati Martins", 1652569, 0.778)});

        Cadastro cadastro = new Cadastro(new Estado[] {e1,e2,e3});

        Scanner scan = new Scanner(System.in);

        cadastro.mostrarEstados();
        System.out.println("\nDigite o estado: ");
        String estado = scan.nextLine();
        cadastro.mostrarCidades(estado);
        System.out.println("\nDigite a cidade: ");
        String cidade = scan.nextLine();
        cadastro.mostraUmaCidade(estado, cidade);



    }
}
