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

        Contato contato_1 = new Contato();
        contato_1.descricao = "Número Janeide";
        contato_1.telefone = "98985371232";
        contato_1.tipo = 1;

        Contato contato_2 = new Contato();
        contato_2.descricao = "Contato escritório - Janeide";
        contato_2.telefone = "98985375412";
        contato_2.tipo = 2;

        Cliente cliente_1 = new Cliente();
        cliente_1.nome = "Janeide";
        cliente_1.cpf = "45141425235";
        cliente_1.enderecos[0] = endereco;
        cliente_1.contatos[0] = contato_1;
        cliente_1.contatos[1] = contato_2;

        ContaCorrente contaCorrente_1 = new ContaCorrente();
        contaCorrente_1.chequeEspecial = 100.00;
        contaCorrente_1.saldo = 100.00;
        contaCorrente_1.agencia = 3333;
        contaCorrente_1.numeroConta = "22.222-2";
        contaCorrente_1.cliente = cliente_1;


        // Cliente 2
        Endereco endereco_2 = new Endereco();
        endereco.tipo = 1;
        endereco.logradouro = "Rua Nice Lobão";
        endereco.cep = "65061000";
        endereco.cidade = "Bacabal";
        endereco.complemento = "Casa amarela";
        endereco.estado = "Teresina";
        endereco.numero = 101;
        endereco.pais = "Brasil";

        Contato contato_3 = new Contato();
        contato_1.descricao = "Número Maria";
        contato_1.telefone = "47546616166";
        contato_1.tipo = 1;

        Cliente cliente_2 = new Cliente();
        cliente_2.nome = "Maria";
        cliente_2.cpf = "46989737085";
        cliente_2.enderecos[0] = endereco_2;
        cliente_2.contatos[0] = contato_3;

        ContaCorrente contaCorrente_2 = new ContaCorrente();
        contaCorrente_2.chequeEspecial = 100.00;
        contaCorrente_2.saldo = 100.00;
        contaCorrente_2.agencia = 2568;
        contaCorrente_2.numeroConta = "30.000-x";
        contaCorrente_2.cliente = cliente_2;

        // Testes da transferencia
        System.out.println("SALDO DA MARIA ANTES DO SAQUE");
        contaCorrente_2.imprimirContaCorrente();

        boolean teste = contaCorrente_2.sacar(150.00);
        imprimirTesteSaque(teste);

        teste = contaCorrente_2.sacar(65.00);
        imprimirTesteSaque(teste);
        contaCorrente_2.imprimirContaCorrente();
        contaCorrente_2.depositar(35.00);
        contaCorrente_2.imprimirContaCorrente();

        System.out.println("SALDO DA JANIEDE ANTES DA TRANSFERÊNCIA PARA MARIA");
        contaCorrente_1.imprimirContaCorrente();
        teste = contaCorrente_1.transferir(contaCorrente_2, 85.00);
        imprimirTransferencia(teste);
        contaCorrente_2.imprimirContaCorrente();

        contaCorrente_1.imprimirContaCorrente();

        // Testando deposito
        System.out.println("DEPOSITAR PARA CONTA DA JANIEDE");
        teste = contaCorrente_1.depositar(-100.00);
        imprimirDeposito(teste);
        teste = contaCorrente_1.depositar(100.00);
        imprimirDeposito(teste);
        contaCorrente_1.imprimirContaCorrente();

        // Testando sacar
        System.out.println("SACAR DA CONTA DA JANIEDE");
        teste = contaCorrente_1.sacar(-100.00);
        imprimirTesteSaque(teste);
        teste = contaCorrente_1.sacar(100.00);
        imprimirTesteSaque(teste);
        contaCorrente_1.imprimirContaCorrente();

        // IMPRIMINDO AS DUAS CONTAS
        System.out.println("MOSTRANDO AS CONTAS");
        contaCorrente_1.imprimirContaCorrente();
        contaCorrente_2.imprimirContaCorrente();

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
