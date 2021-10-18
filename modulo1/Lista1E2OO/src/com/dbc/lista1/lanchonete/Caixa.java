package com.dbc.lista1.lanchonete;

public class Caixa {
    public String calcularTroco(Double valorTotal, Double valorPago) {
        if (ehValido(valorTotal, valorPago)) {
            return "R$" + (valorPago - valorTotal);
        } else {
            return "O valor pago deve ser maior ou igual ao valor consumido.";
        }


    }

    public Boolean ehValido(Double valorTotal, Double valorPago) {
        if (valorPago < valorTotal) {
            return false;
        } else {
            return true;
        }
    }
}
