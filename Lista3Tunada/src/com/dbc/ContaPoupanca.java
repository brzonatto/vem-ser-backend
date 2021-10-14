package com.dbc;

public class ContaPoupanca extends Conta implements Impressao {
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {

    }

    @Override
    public void imprimir() {

    }
}
