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
        if(saldo >= valorParaDebitar){
            saldo -= valorParaDebitar;
            return true;
        } else {
            boolean temSaldoComChequeEspecial =
                    retornarSaldoComChequeEspecial() - valorParaDebitar >= 0;
            if(temSaldoComChequeEspecial){
                saldo -= valorParaDebitar;
                return true;
            }
            return false;
        }
    }

    boolean validarValor(Double valor){
        // Usar para validar se o valor é negativo;
        if(valor < 0 ){
            System.out.println("Ops! Valor informado é negativo");
            return false;
        } else {
            return true;
        }
    }

    boolean sacar(Double valorParaSacar){
        // Sacar o valor
        boolean valorNaoENegativo =  validarValor(valorParaSacar);
        if(!valorNaoENegativo) return false;
        return debitar(valorParaSacar);
    }

    boolean depositar(Double valorParaDepositar){
        // Depositar o valor
        boolean valorNaoENegativo = validarValor(valorParaDepositar);
        if(!valorNaoENegativo) return false;

        saldo += valorParaDepositar;
        return true;
    }

    Double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    boolean transferir(ContaCorrente contaCorrente, Double valorParaTransferir){
        // Transferência entre contas
        boolean valorNaoENegativo =  validarValor(valorParaTransferir);
        if(!valorNaoENegativo) return false;

        boolean saldoSuficiente = debitar(valorParaTransferir);
        if(saldoSuficiente){
            contaCorrente.depositar(valorParaTransferir);
            return  true;
        }
        return false;
    }

}
