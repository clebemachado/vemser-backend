package models;

import abstracts.Conta;
import interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia,
                         Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    Double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }

    @Override
    public boolean sacar(Double valor){
        if(valor > 0 && retornarSaldoComChequeEspecial() > 0){
            setSaldo(-valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("-------------------------------------");
        System.out.println("Cliente: " + getCliente().getNome() + " | Tipo de conta: Corrente");
        System.out.println("Agencia: " + getAgencia() + " | Conta: " + getNumeroConta());
        System.out.println("Saldo: " + getSaldo() + " | Cheque especial: " + chequeEspecial);
        System.out.println("-------------------------------------");
    }
}
