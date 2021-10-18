package com.dbc.lista1.tradutor;

public class Cadastro {
    private Palavra[] palavras;

    public Cadastro() {

    }

    public Cadastro(Palavra[] palavras) {
        this.palavras = palavras;
    }

    public Palavra[] getPalavras() {
        return palavras;
    }

    public void setPalavras(Palavra[] palavras) {
        this.palavras = palavras;
    }

    public Boolean existePalavra(String palavra) {
        for (int i = 0; i < this.palavras.length; i++) {
            if (this.palavras[i].getPtBR().equalsIgnoreCase(palavra)
                    || this.palavras[i].getEng().equalsIgnoreCase(palavra)) {
                return true;
            }
        }
        return false;
    }

    public String traduzir(String palavra){
        if (existePalavra(palavra)) {
            for (int i = 0; i < this.palavras.length; i++) {
                if (this.palavras[i].getPtBR().equalsIgnoreCase(palavra)){
                    return this.palavras[i].getEng();
                } else if (this.palavras[i].getEng().equalsIgnoreCase(palavra)) {
                    return this.palavras[i].getPtBR();
                }
            }
        }
        return "A palavra não está cadastrada!";
    }
}
