package Lista_2;

/*
Desenvolver um vetor que contenha 10 números (não será pedido ao usuário), ao
colocar um determinado número deverá ser buscado no vetor por aquele número,
caso não haja será necessário exibir uma mensagem dizendo que não existe aquele
determinado número digitado.
 */

public class Ex_6 {
    public static void main(String[] args) {
        int[] valores = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int valorUser = 5;

        boolean encontrado = false;
        for(int valor: valores){
            if(valor == valorUser){
                System.out.println("Valor encontrado");
                encontrado = true;
                break;
            }
        }

        if(!encontrado) System.out.println("Valor não encontrado.");
    }
}
