package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class MatrizEscola {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        int[][] valores = new int[5][4];
        int maiorNotaFinal = 0;
        int matriculaMaior = 0;
        int somaNotasFinais = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "° aluno, número de matrícula: ");
            int matricula = scan.nextInt();
            System.out.println((i + 1) + "° aluno, média das provas: ");
            int mediaProvas = scan.nextInt();
            System.out.println((i + 1) + "° aluno, média dos trabalhos: ");
            int mediaTrabalhos = scan.nextInt();

            double notaFinal = mediaProvas * 0.6 + mediaTrabalhos * 0.4;

            valores[i][0] = matricula;
            valores[i][1] = mediaProvas;
            valores[i][2] = mediaTrabalhos;
            valores[i][3] = (int) notaFinal;

            if (valores[i][3] > maiorNotaFinal) {
                matriculaMaior = valores[i][0];
                maiorNotaFinal = valores[i][3];
            }

            somaNotasFinais += valores[i][3];
        }

        double mediaNotasFinais = somaNotasFinais / 5;
        System.out.println("A maior nota final foi: " + maiorNotaFinal + ", matricula: " + matriculaMaior);
        System.out.println("Média das notas finais: " + mediaNotasFinais);


    }
}
