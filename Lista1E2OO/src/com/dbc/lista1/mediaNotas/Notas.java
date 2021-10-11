package com.dbc.lista1.mediaNotas;

public class Notas {
    private Double[] notas;

    public Notas() {

    }

    public Notas(Double[] notas) {
        this.notas = notas;
    }

    public Double[] getNotas() {
        return notas;
    }

    public void setNotas(Double[] notas) {
        this.notas = notas;
    }

    public Double calcMedia() {
        Double soma = 0.0;
        for (int i = 0; i < this.notas.length; i++) {
            soma += this.notas[i];
        }
        return soma / this.notas.length;
    }

    public String status(Double media) {
        if (media < 5.1) {
            return "reprovado!";
        } else if (media < 7 && media >= 5.1) {
            return "em exame!";
        } else {
            return "aprovado!";
        }
    }

    @Override
    public String toString() {
        return "Média: " + calcMedia() + "\nStatus: " + status(calcMedia());
    }

}
