package com.dbc.lista2.matrizEscola;

public class Main {
    public static void main(String[] args) {
        Turma t1 = new Turma(5);
//        t1.preencherDados();
        t1.addAlunosTeste();
        t1.calculaNotaFinal();
        System.out.println(t1.matriculaMaiorNota());
        System.out.println(t1.mediaNotasFinais());
        t1.imprimirAlunos();
    }
}
