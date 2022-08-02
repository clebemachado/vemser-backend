import abstracts.Conta;
import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ContaPoupanca contaJuliana = setarContaJuliana();
        Cliente clienteMaria = criarCliente();
        ContaCorrente contaCorrenteMaria = setarContaCorrente(clienteMaria);
        ContaPagamento contaPagamentoMaria = setarContaPagamento(clienteMaria);

        boolean teste;

        // Teste de saque ContaPagamento
        System.out.println("TESTE DE SAQUE CONTAPAGAMENTO");
        teste = contaPagamentoMaria.sacar(-10.00);
        imprimirTesteSaque(teste);
        contaPagamentoMaria.imprimir();
        teste = contaPagamentoMaria.sacar(50.00);
        imprimirTesteSaque(teste);
        contaPagamentoMaria.imprimir();

        // Teste transferencia MARIA - Corrente e Pagamento
        System.out.println("Teste transferencia MARIA - Corrente e Pagamento");
        teste = contaCorrenteMaria.transferir(contaPagamentoMaria, 54.25);
        imprimirTransferencia(teste);
        contaPagamentoMaria.imprimir();

        // Teste transferencia conta pagamento Maria para Juliana
        System.out.println("Teste transferencia conta pagamento Maria para Juliana");
        // Teste com error
        teste = contaPagamentoMaria.transferir(contaJuliana, 100.00);
        imprimirTransferencia(teste);
        contaPagamentoMaria.imprimir();
        contaJuliana.imprimir();
        teste = contaPagamentoMaria.transferir(contaJuliana, 95.75);
        imprimirTransferencia(teste);
        contaJuliana.imprimir();
        contaPagamentoMaria.imprimir();

        // Teste transferencia conta pagamento Maria para Juliana
        System.out.println("Teste deposito contaPagamento");
        teste = contaPagamentoMaria.depositar(-100.00);
        imprimirTesteDeposito(teste);
        teste = contaPagamentoMaria.depositar(100.00);
        imprimirTesteDeposito(teste);
        contaPagamentoMaria.imprimir();

    }

    public static Cliente criarCliente(){
        Endereco endereco = new Endereco(1, "Rua São Domingos", 202,
                "Próximo a quadra", "65061480", "São Luís",
                "Maranhão", "Brasil" );

        Contato contato1 = new Contato("Residencial", "98985371232", 1);
        Contato contato2 = new Contato("Comercial", "98985375412", 2);

        Cliente cliente1 = new Cliente("Maria", "45141425235");

        // Duas formas de adicionar na lista
        cliente1.setContatos(new ArrayList<>(Arrays.asList(contato1, contato2)));
        cliente1.getEnderecos().addAll(Collections.singletonList(endereco));
        return cliente1;
    }

    public static ContaCorrente setarContaCorrente(Cliente cliente){
        return new ContaCorrente(cliente, "2222-2",
                "3333", 100.00, 100.00);
    }

    public static ContaPagamento setarContaPagamento(Cliente cliente){
        return new ContaPagamento(cliente, "8888-2",
                "7777", 100.00);
    }

    public static ContaPoupanca setarContaJuliana(){
        Endereco endereco = new Endereco(1, "Rua Nice Lobao", 202,
                "Próximo a escola", "65061480", "Bacabal",
                "Maranhão", "Brasil" );

        Contato contato1 = new Contato("Residencial", "989874541", 1);
        Contato contato2 = new Contato("Comercial", "989814241", 2);

        Cliente cliente1 = new Cliente("Juliana", "42145874695");
        // Outra forma
        cliente1.setContatos(new ArrayList<>(Arrays.asList(contato1, contato2)));
        cliente1.setEnderecos(new ArrayList<>(Collections.singletonList(endereco)));

        return new ContaPoupanca(cliente1, "9999-2", "2222", 100.00);
    }

    static void imprimirTesteSaque(Boolean testeSaque){
        if(testeSaque){
            System.out.println("Status: saque realizado com sucesso!\n");
        } else{
            System.out.println("Status: saque não realizado!\n");

        }
    }

    static void imprimirTesteDeposito(Boolean testeDeposito){
        if(testeDeposito){
            System.out.println("Status: deposito realizado com sucesso!\n");
        } else{
            System.out.println("Status: deposito não realizado!\n");

        }
    }

    static void imprimirTransferencia(Boolean testeTransferencia){
        if(testeTransferencia){
            System.out.println("Status: transferencia realizada com sucesso!\n");
        } else{
            System.out.println("Status: transferencia não realizada!\n");

        }
    }
}
