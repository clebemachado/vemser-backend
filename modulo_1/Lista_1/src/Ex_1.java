import java.util.Scanner;

public class Ex_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Olá seu nome é "+ nome +
                            ", você tem " + idade + " anos, " +
                            "é da cidade de " + cidade + ", situada " +
                            "no estado de " + estado + ".");

        scanner.close();
    }

}
