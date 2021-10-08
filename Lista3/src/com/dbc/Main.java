package com.dbc;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Brunno", "121.417.725-59");
        cliente1.enderecos[0] = new Endereco(2, "Rua Jõao José Maria", 222,
                "Bloco H", "120345-222", "Porto Alegre", "RS", "Brasil");
        cliente1.enderecos[1] = new Endereco(1, "Rua Oloco", 333,
                "Bloco J", "170385-222", "Porto Alegre", "RS", "Brasil");
        cliente1.contatos[0] = new Contato("Oi", "5198442365", 2);
        cliente1.contatos[1] = new Contato("Vivo", "5194542335", 1);

//        cliente1.imprimirContatos();
//        cliente1.imprimirEnderecos();
//        cliente1.imprimirCliente();

        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "123456", 2115, 2500.00, 500.00);

        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.sacar(2550.00);
        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.sacar(50.00);
        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.depositar(300.00);
        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.depositar(300.00);
        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.depositar(1000.00);
        contaCorrente1.imprimirContaCorrente();








    }
}
