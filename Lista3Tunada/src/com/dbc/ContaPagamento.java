package com.dbc;

import com.dbc.utils.Utils;

public class ContaPagamento extends Conta implements Impressao {
    final static Double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public Boolean sacar(Double valor) {
        if ((valor + TAXA_SAQUE) < this.getSaldo()) {
            return super.sacar(valor + TAXA_SAQUE);
        }
        System.out.println("Saldo insuficiente! É necessario o pagamento da taxa de " + Utils.formatarDouble(TAXA_SAQUE)
                + " para realizar uma transação de saque ou tranferencia.");
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println("Proprietário da conta pagamento: " + super.getCliente().getNome());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Número da conta: " + super.getNumeroConta() + " | Número da Agência: " + super.getAgencia()
                + " | Saldo: " + Utils.formatarDouble(super.getSaldo());
    }
}
