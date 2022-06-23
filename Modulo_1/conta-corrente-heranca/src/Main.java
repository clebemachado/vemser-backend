import abstracts.Conta;
import models.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Arrays.asList("1","2");
        ContaPoupanca contaJuliana = setarContaJuliana();
        ContaCorrente contaMaria = setarContaMaria();

        // Teste depositar
        System.out.println("========================================");
        System.out.println("TESTE DO DEPOSITAR");
        contaJuliana.imprimir();
        System.out.println();
        boolean teste = contaJuliana.depositar(50.00);
        imprimirTesteDeposito(teste);
        contaJuliana.imprimir();

        System.out.println();
        contaMaria.imprimir();
        System.out.println();
        teste = contaMaria.depositar(-10.00);
        imprimirTesteDeposito(teste);
        contaMaria.imprimir();


        // Teste sacar + creditar
        System.out.println("========================================");
        System.out.println("TESTE DO SACAR");
        contaJuliana.sacar(140.00);
        contaJuliana.imprimir();
        contaJuliana.creditarTaxa();
        contaJuliana.imprimir();
        contaJuliana.depositar(100.00);

        // Teste sacar normal
        System.out.println("========================================");
        System.out.println("TESTE DO SACAR");
        contaMaria.sacar(190.00);
        contaMaria.imprimir();
        System.out.println();
        // Teste sacar mais do que o limite do cheque especial
        teste = contaMaria.sacar(20.00);
        imprimirTesteSaque(teste);


        // Teste transferir
        System.out.println("========================================");
        teste = contaMaria.transferir(contaJuliana, 20.00); // Transferencia é para retornar false
        imprimirTransferencia(teste);
        teste = contaJuliana.transferir(contaMaria, -20.00); // Transferencia é para retornar false
        imprimirTransferencia(teste);
        teste = contaJuliana.transferir(contaMaria, 100.0);
        imprimirTransferencia(teste);
        System.out.println("========================================");

        // Mostrar final das contas
        contaJuliana.imprimir();
        contaMaria.imprimir();

    }

    public static ContaCorrente setarContaMaria(){
        Endereco endereco = new Endereco(1, "Rua São Domingos", 202,
                "Próximo a quadra", "65061480", "São Luís",
                "Maranhão", "Brasil" );

        Contato contato1 = new Contato("Residencial", "98985371232", 1);
        Contato contato2 = new Contato("Comercial", "98985375412", 2);

        Cliente cliente1 = new Cliente("Maria", "45141425235");
        cliente1.setContatos(new Contato[]{contato1, contato2});
        cliente1.setEnderecos(new Endereco[]{endereco});

        return new ContaCorrente(cliente1, "2222-2",
                "3333", 100.00, 100.00);
    }

    public static ContaPoupanca setarContaJuliana(){
        Endereco endereco = new Endereco(1, "Rua Nice Lobao", 202,
                "Próximo a escola", "65061480", "Bacabal",
                "Maranhão", "Brasil" );

        Contato contato1 = new Contato("Residencial", "989874541", 1);
        Contato contato2 = new Contato("Comercial", "989814241", 2);

        Cliente cliente1 = new Cliente("Juliana", "42145874695");
        cliente1.setContatos(new Contato[]{contato1, contato2});
        cliente1.setEnderecos(new Endereco[]{endereco});

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
