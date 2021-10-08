package com.dbc;

import java.text.DecimalFormat;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public Integer agencia;
    public Double saldo;
    public Double chequeEspecial;
    public Double creditoChequeEspecial;
    DecimalFormat df = new DecimalFormat("#,##0.00");

    public ContaCorrente(Cliente cliente, String numeroConta, Integer agencia, Double saldo, Double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
        this.creditoChequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println("Proprietário da conta: " + this.cliente.nome);
        System.out.println(this.toString());
    }

    public Boolean sacar(Double valor) {
        Double somaDeSaldos = this.retornarSaldoComChegueEspecial();
        if (valor > somaDeSaldos) {
            return false;
        } else {
            if (valor < saldo) {
                this.saldo -= valor;
            } else {
                valor = valor - saldo;
                this.saldo = 0.0;
                this.chequeEspecial -= valor;
            }
            return true;
        }
    }

    public Boolean depositar(Double valor) {
        if (this.chequeEspecial != this.creditoChequeEspecial) {
            Double saldo = creditoChequeEspecial - chequeEspecial;
            chequeEspecial += saldo;
            valor -= saldo;
            this.saldo += valor;
        }
        return true;
    }

    public Double retornarSaldoComChegueEspecial() {
        return this.saldo + this.chequeEspecial;
    }

    public Boolean transferir(ContaCorrente contaCorrente, Double valor) {
        return true;
    }

    @Override
    public String toString() {
        return "Número da conta: " + this.numeroConta + " Número da Agência: " + this.agencia
                + " Saldo: R$" + df.format(this.saldo) + " Cheque Especial: R$" + df.format(this.chequeEspecial);
    }
}
