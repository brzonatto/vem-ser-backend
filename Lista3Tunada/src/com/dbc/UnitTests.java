package com.dbc;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTests {
    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //SETUP
        ContaCorrente cc = Main.ccBrunno();
        //ACTION
        Boolean sacar = cc.sacar(2000.00);
        Double saldo = cc.getSaldo();
        Double saldoCE = cc.getChequeEspecial();
        //ASSERT
        assertTrue(sacar);
        assertEquals(0.0, saldo, 0);
        assertEquals(4000.00, saldoCE, 0);
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //SETUP
        ContaCorrente cc = Main.ccBrunno();
        //ACTION
        Boolean sacar = cc.sacar(6500.00);
        Double saldo = cc.getSaldo();
        Double saldoCE = cc.getChequeEspecial();
        //ASSERT
        assertFalse(sacar);
        assertEquals(1000.00, saldo, 0);
        assertEquals(5000.00, saldoCE, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        //SETUP
        ContaPoupanca cp = Main.cpCarol();
        cp.creditarTaxa();
        //ACTION
        Boolean sacar = cp.sacar(500.00);
        Double saldo = cp.getSaldo();
        //ASSERT
        assertTrue(sacar);
        assertEquals(510.0, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        //SETUP
        ContaPoupanca cp = Main.cpCarol();
        //ACTION
        Boolean sacar = cp.sacar(1500.00);
        Double saldo = cp.getSaldo();
        //ASSERT
        assertFalse(sacar);
        assertEquals(1000.00, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        //SETUP
        ContaPagamento cpag = Main.cpagBrunno();
        //ACTION
        Boolean sacar = cpag.sacar(500.00);
        Double saldo = cpag.getSaldo();
        //ASSERT
        assertTrue(sacar);
        assertEquals(500.0 - 4.25, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        //SETUP
        ContaPagamento cpag = Main.cpagBrunno();
        //ACTION
        Boolean sacar = cpag.sacar(1500.00);
        Double saldo = cpag.getSaldo();
        //ASSERT
        assertFalse(sacar);
        assertEquals(1000.00, saldo, 0);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        //SETUP
        ContaPagamento cpag = Main.cpagBrunno();
        ContaCorrente cc = Main.ccBrunno();
        ContaPoupanca cp = Main.cpCarol();
        //ACTION
        Boolean transferirDeCPAG = cpag.transferir(cc, 750.10);
        Boolean transferirDeCP = cp.transferir(cpag, 325.29);
        Boolean transferirDeCC = cc.transferir(cp, 770.33);
        Double saldoCPAG = cpag.getSaldo();
        Double saldoCP = cp.getSaldo();
        Double saldoCC = cc.getSaldo();
        //ASSERT
        assertTrue(transferirDeCPAG);
        assertEquals(570.94 , saldoCPAG, 0);
        assertTrue(transferirDeCP);
        assertEquals(1445.04, saldoCP, 0);
        assertTrue(transferirDeCC);
        assertEquals(979.77, saldoCC, 1);

    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        //SETUP
        ContaPagamento cpag = Main.cpagBrunno();
        ContaCorrente cc = Main.ccBrunno();
        ContaPoupanca cp = Main.cpCarol();
        //ACTION
        Boolean transferirDeCPAG = cpag.transferir(cc, 7000.00);
        Boolean transferirDeCP = cp.transferir(cpag, 00.00);
        Boolean transferirDeCC = cc.transferir(cp, 11500.00);
        Double saldoCPAG = cpag.getSaldo();
        Double saldoCP = cp.getSaldo();
        Double saldoCC = cc.getSaldo();
        //ASSERT
        assertFalse(transferirDeCPAG);
        assertEquals(1000.00 , saldoCPAG, 0);
        assertFalse(transferirDeCP);
        assertEquals(1000.00, saldoCP, 0);
        assertFalse(transferirDeCC);
        assertEquals(1000.00, saldoCC, 0);
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        //SETUP
        ContaPagamento cpag = Main.cpagBrunno();
        ContaCorrente cc = Main.ccBrunno();
        ContaPoupanca cp = Main.cpCarol();
        //ACTION
        Boolean depositarCPAG = cpag.depositar(300.00);
        Boolean depositarCP = cp.depositar(880.33);
        Boolean depositarCC = cc.depositar(1033.87);
        Double saldoCPAG = cpag.getSaldo();
        Double saldoCP = cp.getSaldo();
        Double saldoCC = cc.getSaldo();
        //ASSERT
        assertTrue(depositarCPAG);
        assertEquals(1300.00 , saldoCPAG, 0);
        assertTrue(depositarCP);
        assertEquals(1880.33, saldoCP, 0);
        assertTrue(depositarCC);
        assertEquals(2033.87, saldoCC, 0);
    }

    @Test
    public void deveTestarDepositoNegativo() {
        //SETUP
        ContaPagamento cpag = Main.cpagBrunno();
        ContaCorrente cc = Main.ccBrunno();
        ContaPoupanca cp = Main.cpCarol();
        //ACTION
        Boolean depositarCPAG = cpag.depositar(-300.00);
        Boolean depositarCP = cp.depositar(0.0);
        Boolean depositarCC = cc.depositar(-1033.87);
        Double saldoCPAG = cpag.getSaldo();
        Double saldoCP = cp.getSaldo();
        Double saldoCC = cc.getSaldo();
        //ASSERT
        assertFalse(depositarCPAG);
        assertEquals(1000.00 , saldoCPAG, 0);
        assertFalse(depositarCP);
        assertEquals(1000.00, saldoCP, 0);
        assertFalse(depositarCC);
        assertEquals(1000.00, saldoCC, 0);
    }
}
