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
        return null;
    }

    @Override
    public Boolean depositar(Double valor) {
        return null;
    }
    @Override
    public Boolean transferir(Conta conta, Double valor) {
        return null;
    }

    @Override
    public String toString() {
        return "Número da conta: " + this.numeroConta + " Número da Agência: " + this.agencia
                + " Saldo: " + Utils.formatarDouble(this.saldo);
    }
}
