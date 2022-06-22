import java.util.Arrays;

public class Cliente {

    String nome;
    String cpf;
    Contato[] contatos= new Contato[2];
    Endereco[] enderecos= new Endereco[2];

    void imprimirContatos(){
        for (Contato contato: contatos) {
            if(contato != null) System.out.println(contato);
        }
    }

    void imprimirEndereco(){
        for (Endereco endereco: enderecos) {
            if(endereco != null) System.out.println(endereco);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "\n" +
                "   nome='" + nome + "\n" +
                "   cpf='" + cpf + "\n" +
                '}';
    }
}
