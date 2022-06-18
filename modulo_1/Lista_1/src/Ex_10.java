import java.util.Scanner;

public class Ex_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de eleitores: ");
        int qtdDeEleitores = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Quantidade de votos brancos: ");
        int qtdDeVotosBrancos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Quantidade de votos nulos: ");
        int qtdDeVotosNulos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Quantidade de votos válidos: ");
        int qtdDeVotosValidos = scanner.nextInt();
        scanner.nextLine();

        double percentualBrancos = ((double) qtdDeVotosBrancos / qtdDeEleitores) * 100;
        double percentualNulos = ((double) qtdDeVotosNulos / qtdDeEleitores) * 100;
        double percentualValidos =  ((double) qtdDeVotosValidos / qtdDeEleitores) * 100;

        System.out.println("Votos válidos: " + percentualValidos + "%");
        System.out.println("Votos brancos: " + percentualBrancos + "%");
        System.out.println("Votos nulos: " + percentualNulos + "%");

        scanner.close();
    }
}
