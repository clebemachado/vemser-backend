public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    Integer agencia;
    Double saldo;
    Double chequeEspecial;

    void imprimirContaCorrente(){
        System.out.println("==================================================");
        System.out.println("Titular: " + cliente.nome);
        System.out.println("Agencia: " + agencia + ". Número da conta: " + numeroConta);
        System.out.println("Saldo: " + saldo + ". Cheque especial " + chequeEspecial);
        System.out.println("==================================================\n");

    }

    boolean debitar(Double valorParaDebitar){
        // Usar para transferência, sacar e debitar
        if(valorParaDebitar <= retornarSaldoComChequeEspecial() && valorParaDebitar > 0){
            saldo -= valorParaDebitar;
            return true;
        } else {
            return false;
        }
    }

    boolean sacar(Double valorParaSacar){
        // Sacar o valor
        if(valorParaSacar < 0) return false;
        return debitar(valorParaSacar);
    }

    boolean depositar(Double valorParaDepositar){
        // Depositar o valor
        if(valorParaDepositar < 0) return false;
        saldo += valorParaDepositar;
        return true;
    }

    Double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    boolean transferir(ContaCorrente contaCorrente, Double valorParaTransferir){
        // Transferência entre contas
        if(valorParaTransferir < 0) return false;

        boolean saldoSuficiente = debitar(valorParaTransferir);
        if(saldoSuficiente){
            contaCorrente.depositar(valorParaTransferir);
            return  true;
        }
        return false;
    }

}
