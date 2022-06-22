public class Main {
    public static void main(String[] args) {

        // Cliente 1
        Endereco endereco = new Endereco();
        endereco.tipo = 1;
        endereco.logradouro = "Rua São Domingos";
        endereco.cep = "65061480";
        endereco.cidade = "São Luís";
        endereco.complemento = "Próximo a quadra";
        endereco.estado = "Maranhão";
        endereco.numero = 202;
        endereco.pais = "Brasil";

        Contato contato1 = new Contato();
        contato1.descricao = "Número Janeide";
        contato1.telefone = "98985371232";
        contato1.tipo = 1;

        Contato contato2 = new Contato();
        contato2.descricao = "Contato escritório - Janeide";
        contato2.telefone = "98985375412";
        contato2.tipo = 2;

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Janeide";
        cliente1.cpf = "45141425235";
        cliente1.enderecos[0] = endereco;
        cliente1.contatos[0] = contato1;
        cliente1.contatos[1] = contato2;

        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.chequeEspecial = 100.00;
        contaCorrente1.saldo = 100.00;
        contaCorrente1.agencia = 3333;
        contaCorrente1.numeroConta = "22.222-2";
        contaCorrente1.cliente = cliente1;


        // Cliente 2
        Endereco endereco2 = new Endereco();
        endereco.tipo = 1;
        endereco.logradouro = "Rua Nice Lobão";
        endereco.cep = "65061000";
        endereco.cidade = "Bacabal";
        endereco.complemento = "Casa amarela";
        endereco.estado = "Teresina";
        endereco.numero = 101;
        endereco.pais = "Brasil";

        Contato contato3 = new Contato();
        contato1.descricao = "Número Maria";
        contato1.telefone = "47546616166";
        contato1.tipo = 1;

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Maria";
        cliente2.cpf = "46989737085";
        cliente2.enderecos[0] = endereco2;
        cliente2.contatos[0] = contato3;

        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.chequeEspecial = 100.00;
        contaCorrente2.saldo = 100.00;
        contaCorrente2.agencia = 2568;
        contaCorrente2.numeroConta = "30.000-x";
        contaCorrente2.cliente = cliente2;

        // Testes da transferencia
        System.out.println("SALDO DA MARIA ANTES DO SAQUE");
        contaCorrente2.imprimirContaCorrente();

        boolean teste = contaCorrente2.sacar(150.00);
        imprimirTesteSaque(teste);

        teste = contaCorrente2.sacar(65.00);
        imprimirTesteSaque(teste);
        contaCorrente2.imprimirContaCorrente();
        contaCorrente2.depositar(35.00);
        contaCorrente2.imprimirContaCorrente();

        System.out.println("SALDO DA JANIEDE ANTES DA TRANSFERÊNCIA PARA MARIA");
        contaCorrente1.imprimirContaCorrente();
        teste = contaCorrente1.transferir(contaCorrente2, 85.00);
        imprimirTransferencia(teste);
        contaCorrente2.imprimirContaCorrente();

        contaCorrente1.imprimirContaCorrente();

        // Testando deposito
        System.out.println("DEPOSITAR PARA CONTA DA JANIEDE");
        teste = contaCorrente1.depositar(-100.00);
        imprimirDeposito(teste);
        teste = contaCorrente1.depositar(100.00);
        imprimirDeposito(teste);
        contaCorrente1.imprimirContaCorrente();

        // Testando sacar
        System.out.println("SACAR DA CONTA DA JANIEDE");
        teste = contaCorrente1.sacar(-100.00);
        imprimirTesteSaque(teste);
        teste = contaCorrente1.sacar(100.00);
        imprimirTesteSaque(teste);
        contaCorrente1.imprimirContaCorrente();

        // IMPRIMINDO AS DUAS CONTAS
        System.out.println("MOSTRANDO AS CONTAS");
        contaCorrente1.imprimirContaCorrente();
        contaCorrente2.imprimirContaCorrente();

    }

    static void imprimirTesteSaque(Boolean testeSaque){
        if(testeSaque){
            System.out.println("Saque realizado com sucesso!\n");
        } else{
            System.out.println("Saque não realizado!\n");

        }
    }

    static void imprimirDeposito(Boolean testeDeposito){
        if(testeDeposito){
            System.out.println("Deposito realizado com sucesso!\n");
        } else{
            System.out.println("Deposito não realizado!\n");

        }
    }

    static void imprimirTransferencia(Boolean testeTransferencia){
        if(testeTransferencia){
            System.out.println("Transferencia realizada com sucesso!\n");
        } else{
            System.out.println("Transferencia não realizada!\n");

        }
    }
}
