package com.dbc.lista2.matrizEscola;

import com.dbc.utils.Utils;

public class Aluno {
    private Integer numeroMatricula;
    private Double mediaProvas;
    private Double mediaTrabalhos;
    private Double notaFinal;

    public Aluno() {

    }

    public Aluno(Integer numeroMatricula, Double mediaProvas, Double mediaTrabalhos) {
        this.numeroMatricula = numeroMatricula;
        this.mediaProvas = mediaProvas;
        this.mediaTrabalhos = mediaTrabalhos;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Double getMediaProvas() {
        return mediaProvas;
    }

    public void setMediaProvas(Double mediaProvas) {
        this.mediaProvas = mediaProvas;
    }

    public Double getMediaTrabalhos() {
        return mediaTrabalhos;
    }

    public void setMediaTrabalhos(Double mediaTrabalhos) {
        this.mediaTrabalhos = mediaTrabalhos;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return  "--------------------------------" +
                "\nMatricula: " + this.numeroMatricula +
                "\nMedia Provas: " + Utils.formatarDouble2casas(this.mediaProvas) +
                "\nMedia Trabalhos: " + Utils.formatarDouble2casas(this.mediaTrabalhos) +
                "\nNota Final: " + Utils.formatarDouble2casas(this.notaFinal);
    }
}
