package teste;

import models.ContaCorrente;
import models.ContaPagamento;
import models.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaPoupancaTest {
    public static double valorSaldo = 100.00;

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){

        // SETUP
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(100.00);

        // TAXA * SAQUE = 100.00 * 1.01 = 101
        contaPoupanca.creditarTaxa();

        double sacarValor = 101.00;

        // Ação
        boolean deveSacar = contaPoupanca.sacar(sacarValor);

        // Assets
        Assertions.assertTrue(deveSacar);
        Assertions.assertEquals(0, contaPoupanca.getSaldo());

    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo(){
        // SETUP
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(100.00);

        // TAXA * SAQUE = 100.00 * 1.01 = 101.00
        contaPoupanca.creditarTaxa();

        double sacarValor = 102.00;

        // Ação
        boolean deveSacar = contaPoupanca.sacar(sacarValor);

        // Assets
        Assertions.assertFalse(deveSacar);
        Assertions.assertEquals(101.00, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        // Setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(valorSaldo);


        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(0.00);
        contaCorrente.setChequeEspecial(0.00);

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(0.00);

        // Ação
        contaPoupanca.creditarTaxa(); // + 1.01 * getSaldo() - 1 vez no mês

        double valorparaTransferirContaCorrent = 50.00;
        boolean transferirParaContaCorrente =
                contaPoupanca.transferir(contaCorrente, valorparaTransferirContaCorrent);

        double valorParaTransferirContaPagamento = 50.00;
        boolean transferirParaContaPagamento =
                contaPoupanca.transferir(contaPagamento, valorParaTransferirContaPagamento);

        double valorFinalPoupanca = 1.01 * valorSaldo
                - valorparaTransferirContaCorrent
                -valorParaTransferirContaPagamento;
        // Asserts

        Assertions.assertTrue(transferirParaContaCorrente);
        Assertions.assertTrue(transferirParaContaPagamento);

        Assertions.assertEquals(valorFinalPoupanca, contaPoupanca.getSaldo());

        Assertions.assertEquals(
                valorparaTransferirContaCorrent,
                contaCorrente.getSaldo()
        );

        Assertions.assertEquals(
                valorparaTransferirContaCorrent,
                contaCorrente.saldoComChequeEspecial()
        );

        Assertions.assertEquals(
                valorParaTransferirContaPagamento,
                contaPagamento.getSaldo()
        );

    }

    @Test
    public void deveTestarTransferenciaSemSaldo(){
        // Setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(valorSaldo);

        ContaCorrente contaCorrenteUser = new ContaCorrente();
        double saldoUser = 0.00;
        double saldoChequeEspecialUser = 10.00;
        contaCorrenteUser.setSaldo(saldoUser);
        contaCorrenteUser.setChequeEspecial(saldoChequeEspecialUser);

        // Ação -> Será creditado por escolha do usuário
        contaPoupanca.creditarTaxa();
        double valorParaTransferir = 102.00;
        boolean transferiaSemSucesso =
                contaPoupanca.transferir(contaCorrenteUser, valorParaTransferir);

        double valorFinalPoupanca = 1.01 * valorSaldo;
        // Asserts
        Assertions.assertFalse(transferiaSemSucesso);
        Assertions.assertEquals(
                valorFinalPoupanca,
                contaPoupanca.getSaldo()
        );
        Assertions.assertEquals(
                saldoUser,
                contaCorrenteUser.getSaldo()
        );
        Assertions.assertEquals(
                saldoChequeEspecialUser + saldoUser,
                contaCorrenteUser.saldoComChequeEspecial()
        );
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(valorSaldo);

        // act -> por escolha do usuário, será creditado na poupança
        contaPoupanca.creditarTaxa();
        double valorDeposito = 101.00;
        boolean conseguiuDepositar = contaPoupanca.depositar(valorDeposito);

        // assert
        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertNotEquals(
                valorSaldo + valorDeposito,
                contaPoupanca.getSaldo()
        );
        Assertions.assertEquals(
                valorSaldo * 1.01 + valorDeposito,
                contaPoupanca.getSaldo()
        );

    }

    @Test
    public void deveTestarDepositoNegativo(){
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(valorSaldo);

        // act -> por escolha do usuário, não será creditado na poupança
        double valorDeposito = -100.00;
        boolean naoConseguiuDepositar = contaPoupanca.depositar(valorDeposito);

        // assert
        Assertions.assertFalse(naoConseguiuDepositar);
        Assertions.assertTrue(contaPoupanca.getSaldo() instanceof Double); // só para ver outros métodos
        Assertions.assertEquals(
                valorSaldo,
                contaPoupanca.getSaldo()
        );
        Assertions.assertNotEquals(
                valorSaldo * 1.01,
                contaPoupanca.getSaldo()
        );
    }
}
