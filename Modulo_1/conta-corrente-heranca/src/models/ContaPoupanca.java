package models;

import abstracts.Conta;
import interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {

    public static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa(){
        Double saldoAtual = getSaldo() * JUROS_MENSAL;
        setSaldo(saldoAtual);
    }

    @Override
    public void imprimir() {
        System.out.println("-------------------------------------");
        System.out.println("Cliente: " + getCliente().getNome() + " | Tipo de conta: Poupança");
        System.out.println("Agencia: " + getAgencia() + " | Conta: " + getNumeroConta());
        System.out.println("Saldo: " + getSaldo() );
        System.out.println("-------------------------------------");
    }
}
