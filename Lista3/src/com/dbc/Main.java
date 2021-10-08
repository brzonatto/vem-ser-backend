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


        Cliente cliente2 = new Cliente("Caroline", "151.677.909-05");
        cliente2.enderecos[0] = new Endereco(2, "Rua Seila", 323,
                "Bloco P", "123455-252", "Porto Alegre", "RS", "Brasil");
        cliente2.enderecos[1] = new Endereco(1, "Rua Oloquinho Meu", 443,
                "Bloco K", "17455-562", "Porto Alegre", "RS", "Brasil");
        cliente2.contatos[0] = new Contato("Claro", "5198909365", 2);
        cliente2.contatos[1] = new Contato("Tim", "5199325335", 1);

        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "123456", 2115, 1000.00, 500.00);
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "654321", 2115, 1000.00, 250.00);

        contaCorrente1.imprimirContaCorrente();
        System.out.println("--------------------------------------------------------------------------------");
        contaCorrente2.imprimirContaCorrente();

        contaCorrente1.transferir(contaCorrente2, 200.00);

        System.out.println("--------------------------------------------------------------------------------");
        contaCorrente1.imprimirContaCorrente();
        System.out.println("--------------------------------------------------------------------------------");
        contaCorrente2.imprimirContaCorrente();

        contaCorrente2.sacar(1450.00);

        System.out.println("--------------------------------------------------------------------------------");
        contaCorrente2.imprimirContaCorrente();

        contaCorrente1.transferir(contaCorrente2, 300.00);

        System.out.println("--------------------------------------------------------------------------------");
        contaCorrente1.imprimirContaCorrente();
        System.out.println("--------------------------------------------------------------------------------");
        contaCorrente2.imprimirContaCorrente();










    }
}
