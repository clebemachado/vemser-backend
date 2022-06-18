import java.util.Scanner;

public class Ex_4 {

    public static void main(String[] args) {

        int selecionaEstado;
        int selecionarCidade;
        String opcoesCidade;
        String informacoesDaCidade;
        boolean validaCidade;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecionar estados: [1] - Maranhão [2] - Pará [3] - Piauí");
        System.out.print("Selecionar estado: ");
        selecionaEstado = scanner.nextInt();
        scanner.nextLine();

        if (selecionaEstado == 1){
            opcoesCidade = "[1] - São Luís  [2] - Alcantara";
        } else if (selecionaEstado == 2){
            opcoesCidade = "[1] - Belém  [2] - Marabá";
        } else if (selecionaEstado == 3){
            opcoesCidade = "[1] - Teresina  [2] - Parnaíba";
        } else {
            System.out.println("Estado informado inválido.");
            return;
        }

        System.out.println("Cidades: " + opcoesCidade);
        System.out.print("Selecionar cidade: " );
        selecionarCidade = scanner.nextInt();
        scanner.nextLine();

        validaCidade = selecionarCidade >= 1 && selecionarCidade <= 2 ;

        if (!validaCidade){
            System.out.println("A cidade informada é inválida.");
            return;
        }

        if( selecionaEstado == 1 ){
            informacoesDaCidade = selecionarCidade == 1
                    ? "População: 1.115.932 | Festa: festa junina | IDH:0.768"
                    : "População: 22.126 | Festa: festa do divino | IDH:0,573";
        } else if( selecionaEstado == 2 ){
            informacoesDaCidade = selecionarCidade == 1
                    ? "População: 1.393.399 | Festa: Círio de Nazaré | IDH:0.727"
                    : "População: 287.664 | Festa: Tambor-de-Malta | IDH:0.668";
        }
        else {
            informacoesDaCidade = selecionarCidade == 1
                    ? "População: 871.126 | Festa: festa junina | IDH:0.751"
                    : "População: 153.863 | Festa: Festejo de São Francisco | IDH:0.687";
        }

        System.out.println("Informações da cidade: " + informacoesDaCidade);

        scanner.close();
    }

}
