package com.dbc;

public class Main {
    public static void main(String[] args) {
        // INSTÂNCIAS
        Cliente cliente1 = new Cliente("Brunno", "121.417.725-59");
        cliente1.getEnderecos()[0] = new Endereco(2, "Rua Jõao José Maria", 222,
                "Bloco H", "120345-222", "Porto Alegre", "RS", "Brasil");
        cliente1.getEnderecos()[1] = new Endereco(1, "Rua Oloco", 333,
                "Bloco J", "170385-222", "Porto Alegre", "RS", "Brasil");
        cliente1.getContatos()[0] = new Contato("Oi", "5198442365", 2);
        cliente1.getContatos()[1] = new Contato("Vivo", "5194542335", 1);


        Cliente cliente2 = new Cliente("Caroline", "151.677.909-05");
        cliente2.getEnderecos()[0] = new Endereco(2, "Rua Seila", 323,
                "Bloco P", "123455-252", "Porto Alegre", "RS", "Brasil");
        cliente2.getEnderecos()[1] = new Endereco(1, "Rua Oloquinho Meu", 443,
                "Bloco K", "17455-562", "Porto Alegre", "RS", "Brasil");
        cliente2.getContatos()[0] = new Contato("Claro", "5198909365", 2);
        cliente2.getContatos()[1] = new Contato("Tim", "5199325335", 1);

        ContaPagamento cpag1 = new ContaPagamento(cliente1, "123456", "5555", 1000.00);
        ContaCorrente cc1 = new ContaCorrente(cliente1, "121212", "5555", 1000.00, 500.00);
        ContaPoupanca cp2 = new ContaPoupanca(cliente2, "654321", "6868", 1000.00);

        // TRANSAÇAO NA CONTA
        cpag1.depositar(200.00);
        cpag1.imprimir();
        cpag1.sacar(500.00);
        cpag1.imprimir();
        System.out.println("---------------------");
        cc1.depositar(1000.00);
        cc1.imprimir();
        cc1.sacar(350.00);
        cc1.imprimir();
        System.out.println("---------------------");
        cp2.depositar(5000.00);
        cp2.imprimir();
        cp2.sacar(2000.00);
        cp2.imprimir();
        cp2.creditarTaxa();
        cp2.imprimir();
        System.out.println("#############################");

        // TRANSAÇÃO ENTRE CONTAS
        cc1.transferir(cp2, 1000.00);
        cc1.imprimir();
        cp2.imprimir();
        System.out.println("---------------------");
        cc1.transferir(cpag1, 300.00);
        cc1.imprimir();
        cpag1.imprimir();
        System.out.println("---------------------");
        cpag1.transferir(cc1, 500.00);
        cpag1.imprimir();
        cc1.imprimir();
        System.out.println("---------------------");
        cp2.transferir(cpag1, 1000.00);
        cp2.imprimir();
        cpag1.imprimir();
        System.out.println("---------------------");
    }
}
