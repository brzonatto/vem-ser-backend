package com.dbc;

public class Main {
    public static void main(String[] args) {
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

//        cliente1.imprimirCliente();
//        System.out.println("\n#############################\n");
//        cliente2.imprimirCliente();

        ContaPoupanca cp1 = new ContaPoupanca(cliente1, "123456", "3333", 1000.00);
        cp1.imprimir();
//        cp1.imprimir();
//        cp1.sacar(50.00);
//        cp1.imprimir();
//        cp1.sacar(5000.00);
//        cp1.imprimir();
//        cp1.sacar(0.00);
//        cp1.imprimir();
//        cp1.creditarTaxa();
//        cp1.imprimir();
//        cp1.depositar(5000.00);
//        cp1.imprimir();
//        cp1.creditarTaxa();

        ContaCorrente cc1 = new ContaCorrente(cliente2, "654321", "3333", 1000.00, 500.00);
        cc1.imprimir();
        cc1.imprimir();
        cc1.sacar(500.00);
        cc1.imprimir();
        cc1.sacar(750.00);
        cc1.imprimir();
        cc1.sacar(-500.00);
        cc1.imprimir();
        cc1.depositar(500.00);
        cc1.imprimir();
        cc1.sacar(800.00);
        cc1.imprimir();

        cp1.transferir(cc1, 500.00);
        cp1.imprimir();
        cc1.imprimir();

//        cc1.transferir(cp1, 1250.00);
//        cp1.imprimir();
//        cc1.imprimir();
//        cp1.transferir(cc1, 500.00);
//        cp1.imprimir();
//        cc1.imprimir();
    }
}
