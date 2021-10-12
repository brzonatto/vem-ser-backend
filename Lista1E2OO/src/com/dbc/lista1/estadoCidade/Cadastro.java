package com.dbc.lista1.estadoCidade;

public class Cadastro {
    private Estado[] estados;

    public Cadastro(Estado[] cadastro) {
        this.estados = cadastro;
    }

    public void mostrarEstados() {
        System.out.println("Estados disponíveis: \n");
        for (Estado key: this.estados) {
            System.out.println(key.getNome());
        }
    }

    public Boolean existeEstado(String nomeEstado) {
        for (int i = 0; i < this.estados.length; i++) {
            if (this.estados[i].getNome().equalsIgnoreCase(nomeEstado)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarCidades(String nomeEstado) {
        if (existeEstado(nomeEstado)) {
            System.out.println("\nCidade disponíveis: ");
            for (int i = 0; i < this.estados.length; i++) {
                if (this.estados[i].getNome().equalsIgnoreCase(nomeEstado)) {
                    for (int j = 0; j < this.estados[i].getCidades().length; j++) {
                        System.out.println(this.estados[i].getCidades()[j].getNome());
                    }
                    break;
                }
            }
        } else {
            System.out.println("O estado não está cadastrado!");
            System.exit(1);
        }
    }

    public void mostraUmaCidade(String nomeEstado, String nomeCidade) {
        if (existeEstado(nomeEstado)) {
            for (int i = 0; i < this.estados.length; i++) {
                if (this.estados[i].getNome().equalsIgnoreCase(nomeEstado)) {
                    if (this.estados[i].existeCidade(nomeCidade)) {
                        for (int j = 0; j < this.estados[i].getCidades().length; j++) {
                            if (this.estados[i].getCidades()[j].getNome().equalsIgnoreCase(nomeCidade)) {
                                System.out.println(this.estados[i].getCidades()[j]);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Cidade não cadastrada no estado de " + this.estados[i].getNome());
                    }
                }
            }
        }
    }

    public Estado[] getEstados() {
        return estados;
    }

    public void setEstados(Estado[] estados) {
        this.estados = estados;
    }
}
