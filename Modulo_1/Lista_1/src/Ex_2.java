
import java.util.Locale;
import java.util.Scanner;

public class Ex_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Nota 1: ");
        double nota1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nota 2: ");
        double nota2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nota 3: ");
        double nota3 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nota 4: ");
        double nota4 = scanner.nextDouble();
        scanner.nextLine();
        scanner.close();

        double mediaDasNotas = (nota1 + nota2 + nota3 + nota4) / 4;

        System.out.println("");

        if (mediaDasNotas >= 7) {
            System.out.println("Aluno aprovado. Média: " + mediaDasNotas);
        } else if (mediaDasNotas > 5) {
            System.out.println("Aluno em exame. Média: " + mediaDasNotas);
        } else {
            System.out.println("Aluno reprovado. Média: " + mediaDasNotas );
        }

    }

}
