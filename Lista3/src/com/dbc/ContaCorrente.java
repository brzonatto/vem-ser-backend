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
        if (valor > 0) {
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
        } else {
            return false;
        }
    }

    public Boolean depositar(Double valor) {
        if (valor > 0) {
            Double diferenca = 0.0;
            if(this.chequeEspecial < this.creditoChequeEspecial) {
                this.chequeEspecial += valor;
                diferenca = this.chequeEspecial - this.creditoChequeEspecial;
                if (diferenca > 0 ) {
                    this.chequeEspecial -= diferenca;
                    this.saldo += diferenca;
                }
            } else {
                this.saldo += valor;
            }
            return true;
        } else {
            return false;
        }
    }

    public Double retornarSaldoComChegueEspecial() {
        return this.saldo + this.chequeEspecial;
    }

    public Boolean transferir(ContaCorrente contaCorrente, Double valor) {
        this.sacar(valor);
        contaCorrente.depositar(valor);
        return true;
    }

    @Override
    public String toString() {
        return "Número da conta: " + this.numeroConta + " Número da Agência: " + this.agencia
                + " Saldo: R$" + df.format(this.saldo) + " Cheque Especial: R$" + df.format(this.chequeEspecial);
    }
}
