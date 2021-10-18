package com.dbc.lista1.tradutor;

public class Palavra {
    private String ptBR;
    private String eng;

    public Palavra() {

    }

    public Palavra(String ptBR, String eng) {
        this.ptBR = ptBR;
        this.eng = eng;
    }

    public String getPtBR() {
        return ptBR;
    }

    public void setPtBR(String ptBR) {
        this.ptBR = ptBR;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    @Override
    public String toString() {
        return "ptBR='" + ptBR + '\'' + ", eng='" + eng + '\'';
    }
}
