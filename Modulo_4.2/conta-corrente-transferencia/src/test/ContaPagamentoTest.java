package test;

import abstracts.Conta;
import models.ContaCorrente;
import models.ContaPagamento;
import models.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaPagamentoTest {

    public static double valorSaldo = 100.00;
    public static final double TAXA = ContaPagamento.TAXA_SAQUE;

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
        // Setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(valorSaldo);

        // Ação
        double valorParaSacar = 50.00;

        boolean podeSacar= contaPagamento.sacar(valorParaSacar); // + 4.25

        // Assert
        Assertions.assertTrue(podeSacar);
        Assertions.assertEquals(
                valorSaldo - valorParaSacar - 4.25,
                contaPagamento.getSaldo()
        );
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        // Setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(valorSaldo);

        // Ação
        double valorParaSacar = 100.00;

        boolean naoPodeSacar= contaPagamento.sacar(valorParaSacar); // + 4.25

        // Assert
        Assertions.assertFalse(naoPodeSacar);
        Assertions.assertEquals(
                valorSaldo,
                contaPagamento.getSaldo()
        );
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        // Setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(valorSaldo);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(0.00);
        contaCorrente.setChequeEspecial(0.00);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(0.00);

        ContaPoupanca contaPoupanca2 = new ContaPoupanca();
        contaPoupanca2.setSaldo(0.00);

        // Ação
        double valorparaTransferirContaCorrent = 50.00;
        boolean transferirParaContaCorrente =
                contaPagamento.transferir(contaCorrente, valorparaTransferirContaCorrent);

        double valorParaTransferirContaPoupanca = 25.00;
        boolean transferirParaContaPoupanca =
                contaPagamento.transferir(contaPoupanca, valorParaTransferirContaPoupanca);

        double saldoFinalPagamento = valorSaldo
                - valorparaTransferirContaCorrent
                - valorParaTransferirContaPoupanca - TAXA * 2;

        double valorParaTransferirContaPoupanca2 = saldoFinalPagamento + 1.00;
        boolean naoEhPossivelTransferirParaPoupanca2 =
                contaPagamento.transferir(contaPoupanca2, valorParaTransferirContaPoupanca2);

        // Asserts

        Assertions.assertTrue(transferirParaContaCorrente);
        Assertions.assertTrue(transferirParaContaPoupanca);
        Assertions.assertFalse(naoEhPossivelTransferirParaPoupanca2);

        Assertions.assertEquals(saldoFinalPagamento, contaPagamento.getSaldo());

        Assertions.assertEquals(
                saldoFinalPagamento,
                contaPagamento.getSaldo()
        );
        Assertions.assertEquals(
                valorparaTransferirContaCorrent,
                contaCorrente.getSaldo()
        );
        Assertions.assertEquals(
                valorparaTransferirContaCorrent,
                contaCorrente.saldoComChequeEspecial()
        );
        Assertions.assertEquals(
                valorParaTransferirContaPoupanca,
                contaPoupanca.getSaldo()
        );
        Assertions.assertNotEquals(
                valorParaTransferirContaPoupanca2,
                contaPoupanca2.getSaldo()
        );
    }

    @Test
    public void deveTestarTransferenciaSemSaldo(){
        // Setup

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(valorSaldo);

        ContaCorrente contaCorrenteUser = new ContaCorrente();
        double saldoUser = 0.00;
        double saldoChequeEspecialUser = 0.00;
        contaCorrenteUser.setSaldo(saldoUser);
        contaCorrenteUser.setChequeEspecial(saldoChequeEspecialUser);

        // Ação
        double valorParaTransferir = 101.01;
        boolean transferiaSemSucesso =
                contaPagamento.transferir(contaCorrenteUser, valorParaTransferir);

        // Asserts
        Assertions.assertFalse(transferiaSemSucesso);
        Assertions.assertEquals(
                valorSaldo,
                contaPagamento.getSaldo()
        );
        Assertions.assertTrue(contaPagamento instanceof ContaPagamento);
        Assertions.assertTrue(contaPagamento instanceof Conta);
        Assertions.assertEquals(
                saldoUser,
                contaCorrenteUser.getSaldo()
        );
        Assertions.assertEquals(
                saldoUser + saldoChequeEspecialUser,
                contaCorrenteUser.saldoComChequeEspecial()
        );
        Assertions.assertNotEquals(
                saldoUser + saldoChequeEspecialUser + valorParaTransferir,
                contaCorrenteUser.saldoComChequeEspecial()
        );

    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        // Setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(valorSaldo);

        // act
        double valorDeposito = 100.00;
        boolean conseguiuDepositar = contaPagamento.depositar(valorDeposito);

        // assert
        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertEquals(
                valorSaldo + valorDeposito,
                contaPagamento.getSaldo()
        );
        Assertions.assertNotEquals(
                valorSaldo + valorDeposito - TAXA,
                contaPagamento.getSaldo()
        );

    }

    @Test
    public void deveTestarDepositoNegativo(){
        // Setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(valorSaldo);

        // act
        double valorDeposito = -100.00;
        boolean naoConseguiuDepositar = contaPagamento.depositar(valorDeposito);

        // assert
        Assertions.assertFalse(naoConseguiuDepositar);
        Assertions.assertEquals(
                valorSaldo,
                contaPagamento.getSaldo()
        );
        Assertions.assertNotEquals(
                valorSaldo + valorDeposito,
                contaPagamento.getSaldo()
        );
        Assertions.assertNotEquals(
                valorSaldo + valorDeposito - TAXA,
                contaPagamento.getSaldo()
        );
    }

}
