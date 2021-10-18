package com.dbc.lista2.matrizEscola;

import com.dbc.utils.Utils;

import java.util.Locale;
import java.util.Scanner;

public class Turma {
    private Aluno[] alunos;

    public Turma() {

    }

    public Turma(Integer tamanho) {
        this.alunos = new Aluno[tamanho];
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public void preencherDados() {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        for (int i = 0; i < this.alunos.length; i++) {
            System.out.println((i + 1) + "° aluno, número de matrícula: ");
            int matricula = scan.nextInt();
            System.out.println((i + 1) + "° aluno, média das provas: ");
            Double mediaProvas = scan.nextDouble();
            System.out.println((i + 1) + "° aluno, média dos trabalhos: ");
            Double mediaTrabalhos = scan.nextDouble();

            this.alunos[i] = new Aluno(matricula, mediaProvas, mediaTrabalhos);
        }
    }

    public void calculaNotaFinal() {
        for (int i = 0; i < this.alunos.length; i++) {
            this.alunos[i].setNotaFinal(this.alunos[i].getMediaProvas() * 0.6
                    + this.alunos[i].getMediaTrabalhos() * 0.4);
        }
    }

    public Integer matriculaMaiorNota() {
        Double maiorNota = 0.0;
        Integer matriculaMaior = 0;
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i].getNotaFinal() > maiorNota) {
                matriculaMaior = this.alunos[i].getNumeroMatricula();
            }
        }
        return matriculaMaior;
    }

    public String mediaNotasFinais() {
        Double soma = 0.0;
        for (int i = 0; i < this.alunos.length; i++) {
            soma += this.alunos[i].getNotaFinal();
        }
        Double media = soma / this.alunos.length;
        return Utils.formatarDouble2casas(media);
    }

    public void addAlunosTeste() {
        for (int i = 0; i < this.alunos.length; i++) {
            this.alunos[i] = new Aluno(Utils.sortearNumero(1000),
                    Utils.sortearNumeroDouble(10.0),
                    Utils.sortearNumeroDouble(10.0));
        }
    }

    public void imprimirAlunos() {
        for (Aluno key : alunos) {
            System.out.println(key);
        }
    }
}
