package com.dbc;

import java.text.DecimalFormat;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public Integer agencia;
    public Double saldo;
    public Double chequeEspecial;
    public Double creditoChequeEspecial;
    public DecimalFormat df = new DecimalFormat("#,##0.00");

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
        System.out.println(this);
    }

    public Boolean sacar(Double valor) {
        if (valor > 0) {
            Double somaDeSaldos = this.retornarSaldoComChegueEspecial();
            if (valor > somaDeSaldos) {
                System.out.println("Falha no saque! Saldo insuficiente.");
                return false;
            } else {
                if (valor < saldo) {
                    this.saldo -= valor;
                } else {
                    valor = valor - saldo;
                    this.saldo = 0.0;
                    this.chequeEspecial -= valor;
                }
                System.out.println("Saque efetuado com sucesso!");
                return true;
            }
        } else {
            System.out.println("Falha no saque! Valor deve ser positivo e maior que R$0,00.");
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
            System.out.println("Deposito Efetuado com sucesso!");
            return true;
        } else {
            System.out.println("Falha no deposito! Valor deve ser positivo e maior que R$0,00.");
            return false;
        }
    }

    public Double retornarSaldoComChegueEspecial() {
        return this.saldo + this.chequeEspecial;
    }

    public Boolean transferir(ContaCorrente contaCorrente, Double valor) {
        this.sacar(valor);
        contaCorrente.depositar(valor);
        this.imprimirContaCorrente();
        contaCorrente.imprimirContaCorrente();
        return true;
    }

    @Override
    public String toString() {
        return "Número da conta: " + this.numeroConta + " Número da Agência: " + this.agencia
                + " Saldo: R$" + df.format(this.saldo) + " Cheque Especial: R$" + df.format(this.chequeEspecial);
    }
}
