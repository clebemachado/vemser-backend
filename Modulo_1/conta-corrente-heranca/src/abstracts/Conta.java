package abstracts;

import interfaces.Movimentacao;
import models.Cliente;

public abstract class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;

    public Conta(){}

    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(Double valor) {
        if(saldo >= valor && valor > 0){
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(Double valor) {
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta conta, Double valor) {
        if(sacar(valor)){
            return conta.depositar(valor);
        }
        return false;
    }
}
