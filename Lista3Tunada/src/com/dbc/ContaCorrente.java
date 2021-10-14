package com.dbc;

public class ContaCorrente extends Conta implements Impressao {
    private Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial() {
        return null;
    }

    @Override
    public Boolean sacar(Double valor) {
        return null;
    }

    @Override
    public void imprimir() {

    }
}
