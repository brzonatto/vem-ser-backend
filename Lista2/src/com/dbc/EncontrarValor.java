package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class EncontrarValor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		int[] numeros = {0, 5, 10, 15, 25, 30, 35, 40, 45, 50};
		System.out.println("Digite o número que deseja encontrar: ");
		int numeroBusca = scan.nextInt();

		for (int i = 0; i < numeros.length; i++){
			if (numeros[i] == numeroBusca){
				System.out.println("Número encontrado no índice: " + i);
                System.exit(1);
			} else {
				System.out.println("Número não encontrado no vetor");
                System.exit(1);
			}
		}
	}
}
