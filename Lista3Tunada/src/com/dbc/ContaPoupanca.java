package com.dbc;

import com.dbc.utils.Utils;

public class ContaPoupanca extends Conta implements Impressao {
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        super.setSaldo(super.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("Proprietário da conta poupança: " + super.getCliente().getNome());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Número da conta: " + super.getNumeroConta() + " | Número da Agência: " + super.getAgencia()
                + " | Saldo: " + Utils.formatarDouble(super.getSaldo());
    }
}
