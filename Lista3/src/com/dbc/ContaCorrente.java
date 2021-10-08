package com.dbc;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public Integer agencia;
    public Double saldo;
    public Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, Integer agencia, Double saldo, Double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {

    }

    public Boolean sacar(Double valor) {
        return true;
    }

    public Boolean depositar(Double valor) {
        return true;
    }

    public Double retornarSaldoComChegueEspecial() {
        return 1.0;
    }

    public Boolean transferir(ContaCorrente contaCorrente, Double valor) {
        return true;
    }
}
