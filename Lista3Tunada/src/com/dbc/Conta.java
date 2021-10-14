package com.dbc;

import com.dbc.utils.Utils;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;

    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Boolean sacar(Double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque efetuado com sucesso!");
            return true;
        } else {
            System.out.println("Falha no saque! Valor deve ser positivo e maior que R$0,00.");
            return false;
        }
    }

    @Override
    public Boolean depositar(Double valor) {
        if (this instanceof ContaPoupanca || this instanceof ContaPagamento) {
            if (valor > 0) {
                this.saldo += valor;
                System.out.println("Deposito efetuado com sucesso!");
                return true;
            } else {
                System.out.println("Falha no deposito! Valor deve ser positivo e maior que R$0,00.");
                return false;
            }
        } else if (this instanceof ContaCorrente) {
            if (valor > 0) {
                Double diferenca = 0.0;
                if(((ContaCorrente)this).getChequeEspecial() < ((ContaCorrente)this).getCreditoChequeEspecial()) {
                    ((ContaCorrente)this).setChequeEspecial(((ContaCorrente)this).getChequeEspecial() + valor);
                    diferenca = ((ContaCorrente)this).getChequeEspecial() - ((ContaCorrente)this).getCreditoChequeEspecial();
                    if (diferenca > 0 ) {
                        ((ContaCorrente)this).setChequeEspecial(((ContaCorrente)this).getChequeEspecial() - diferenca);
                        this.setSaldo(diferenca + this.getSaldo());
                    }
                } else {
                    this.setSaldo(this.getSaldo() + valor);
                }
                System.out.println("Deposito Efetuado com sucesso!");
                return true;
            } else {
                System.out.println("Falha no deposito! Valor deve ser positivo e maior que R$0,00.");
                return false;
            }
        } else {
            System.out.println("Falha no deposito! Conta inválida!");
            return false;
        }

    }

    @Override
    public Boolean transferir(Conta conta, Double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            System.out.println("Transferido com sucesso!");
            return true;
        } else {
            System.out.println("Falha na transferência!");
            return false;
        }
    }
}
