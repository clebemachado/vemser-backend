package teste;

import models.ContaCorrente;
import models.ContaPagamento;
import models.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {
    public static double valorSaldo = 100.00;
    public static double valorChequeEspecial = 100.00;

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(valorSaldo);
        contaCorrente.setChequeEspecial(valorChequeEspecial);
        double sacarValor = 150.00;

        // act
        boolean conseguiuSacar = contaCorrente.sacar(sacarValor);

        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(50, contaCorrente.saldoComChequeEspecial());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(valorSaldo);
        contaCorrente.setChequeEspecial(valorChequeEspecial);
        double sacarValor = 200.01;

        // act
        boolean naoConseguiuSacar = contaCorrente.sacar(sacarValor);

        // assert
        Assertions.assertFalse(naoConseguiuSacar);
        Assertions.assertEquals(valorSaldo, contaCorrente.getSaldo());
        Assertions.assertEquals(
                valorSaldo + valorChequeEspecial,
                contaCorrente.saldoComChequeEspecial()
        );
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        // Setup
        ContaCorrente contaCorrenteUser1 = new ContaCorrente();
        contaCorrenteUser1.setSaldo(valorSaldo);
        contaCorrenteUser1.setChequeEspecial(valorChequeEspecial);

        ContaCorrente contaCorrenteUser2 = new ContaCorrente();
        contaCorrenteUser2.setSaldo(0.00);
        contaCorrenteUser2.setChequeEspecial(0.00);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(0.00);

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(0.00);

        // Ação
        double valorparaTransferirOutraContaCorrent = 50.00;
        boolean transferirParaOutraContaCorrente =
                contaCorrenteUser1.transferir(contaCorrenteUser2, valorparaTransferirOutraContaCorrent);

        double valorParaTransferirContaPoupanca = 50.00;
        boolean transferirParaContaPoupanca =
                contaCorrenteUser1.transferir(contaPoupanca, valorParaTransferirContaPoupanca);

        double valorParaTransferirContaPagamento = 100.00;
        boolean transferirParaContaPagamento =
                contaCorrenteUser1.transferir(contaPagamento, valorParaTransferirContaPagamento);

        double saldoFinal = - valorParaTransferirContaPagamento
                - valorParaTransferirContaPoupanca
                - valorparaTransferirOutraContaCorrent;

        double saldoValorFinal = valorSaldo + valorChequeEspecial + saldoFinal;

        // Asserts
        Assertions.assertTrue(transferirParaOutraContaCorrente);
        Assertions.assertEquals(saldoValorFinal, contaCorrenteUser1.saldoComChequeEspecial());
        Assertions.assertEquals(
                saldoFinal + valorChequeEspecial,
                contaCorrenteUser1.getSaldo()
        );
        Assertions.assertEquals(
                valorparaTransferirOutraContaCorrent,
                contaCorrenteUser2.getSaldo()
        );
        Assertions.assertEquals(
                valorparaTransferirOutraContaCorrent,
                contaCorrenteUser2.saldoComChequeEspecial()
        );
        Assertions.assertTrue(transferirParaContaPoupanca);
        Assertions.assertEquals(
                valorParaTransferirContaPoupanca,
                contaPoupanca.getSaldo()
        );
        Assertions.assertTrue(transferirParaContaPagamento);
        Assertions.assertEquals(
                valorParaTransferirContaPagamento,
                contaPagamento.getSaldo()
        );

    }

    @Test
    public void deveTestarTransferenciaSemSaldo(){
        // Setup
        double somaSaldoEChequeEspecial = valorSaldo + valorChequeEspecial;

        ContaCorrente contaCorrenteUser1 = new ContaCorrente();
        contaCorrenteUser1.setSaldo(valorSaldo);
        contaCorrenteUser1.setChequeEspecial(valorChequeEspecial);

        ContaCorrente contaCorrenteUser2 = new ContaCorrente();
        double saldoUser2 = 0.00;
        double saldoChequeEspecialUser2 = 0.00;
        contaCorrenteUser2.setSaldo(saldoUser2);
        contaCorrenteUser2.setChequeEspecial(saldoChequeEspecialUser2);

        // Ação
        double valorParaTransferir = 200.01;
        boolean transferiaSemSucesso =
                contaCorrenteUser1.transferir(contaCorrenteUser2, valorParaTransferir);

        // Asserts
        Assertions.assertFalse(transferiaSemSucesso);
        Assertions.assertEquals(
                somaSaldoEChequeEspecial,
                contaCorrenteUser1.saldoComChequeEspecial()
        );
        Assertions.assertEquals(
                valorSaldo,
                contaCorrenteUser1.getSaldo()
        );
        Assertions.assertEquals(
                saldoUser2,
                contaCorrenteUser2.getSaldo()
        );
        Assertions.assertEquals(
                saldoUser2 + saldoChequeEspecialUser2,
                contaCorrenteUser2.saldoComChequeEspecial()
        );
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(valorSaldo);
        contaCorrente.setChequeEspecial(valorChequeEspecial);
        double valorDeposito = 150.00;

        // act
        boolean conseguiuDepositar = contaCorrente.depositar(valorDeposito);

        // assert
        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertEquals(
                valorSaldo + valorDeposito
                , contaCorrente.getSaldo()
        );
        Assertions.assertNotEquals(
                valorSaldo + valorDeposito + 0.001
                , contaCorrente.getSaldo()
        );
        Assertions.assertEquals(
                valorSaldo + valorChequeEspecial + valorDeposito,
                contaCorrente.saldoComChequeEspecial()
        );
        Assertions.assertNotEquals(
                valorSaldo + valorChequeEspecial + valorDeposito + 0.001,
                contaCorrente.saldoComChequeEspecial()
        );
    }

    @Test
    public void deveTestarDepositoNegativo(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(valorSaldo);
        contaCorrente.setChequeEspecial(valorChequeEspecial);
        double valorDeposito = -150.00;

        // act
        boolean naoConseguiuDepositar = contaCorrente.depositar(valorDeposito);

        // assert
        Assertions.assertFalse(naoConseguiuDepositar);
        Assertions.assertEquals(
                valorSaldo
                , contaCorrente.getSaldo()
        );
        Assertions.assertNotEquals(
                valorSaldo + 0.001
                , contaCorrente.getSaldo()
        );
        Assertions.assertEquals(
                valorSaldo + valorChequeEspecial ,
                contaCorrente.saldoComChequeEspecial()
        );
        Assertions.assertNotEquals(
                valorSaldo + valorChequeEspecial + 0.001,
                contaCorrente.saldoComChequeEspecial()
        );
    }
}
