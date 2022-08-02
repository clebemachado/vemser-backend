package models;

import abstracts.Conta;
import interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {

    public static final Double TAXA_SAQUE = 4.25;

    public ContaPagamento() {
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(Double valor){
        Double valorParaDescontar = getSaldo() - TAXA_SAQUE;
        if( valorParaDescontar>= valor && valor > 0){
            setSaldo(valorParaDescontar - valor);
            return true;
        }
        return false;
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
