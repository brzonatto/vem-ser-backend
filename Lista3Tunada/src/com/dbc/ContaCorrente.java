package com.dbc;

import com.dbc.utils.Utils;

public class ContaCorrente extends Conta implements Impressao {
    private Double chequeEspecial;
    private Double creditoChequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
        this.creditoChequeEspecial = chequeEspecial;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public Double getCreditoChequeEspecial() {
        return creditoChequeEspecial;
    }

    public void setCreditoChequeEspecial(Double creditoChequeEspecial) {
        this.creditoChequeEspecial = creditoChequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial() {
        return this.chequeEspecial + super.getSaldo();
    }

    @Override
    public Boolean sacar(Double valor) {
        if (valor > 0) {
            Double somaDeSaldos = retornarSaldoComChequeEspecial();
            if (valor > somaDeSaldos) {
                System.out.println("Falha no saque! Saldo insuficiente.");
                return false;
            } else {
                if (valor < super.getSaldo()) {
                    super.setSaldo(super.getSaldo() - valor);
                } else {
                    valor = valor - super.getSaldo();
                    super.setSaldo(0.0);
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

    @Override
    public void imprimir() {
        System.out.println("Proprietário da conta corrente: " + super.getCliente().getNome());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Número da conta: " + super.getNumeroConta() + " | Número da Agência: " + super.getAgencia()
                + " | Saldo: " + Utils.formatarDouble(super.getSaldo())  + " | Cheque Especial: "
                + Utils.formatarDouble(this.chequeEspecial);
    }
}
