package Lista_1;

import java.util.Scanner;

public class Ex_9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ano do nascimento: ");
        int anoDeNascimento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Mês do nascimento: ");
        int mesDeNascimento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dia do nascimento: ");
        int diaDoNascimento = scanner.nextInt();
        scanner.nextLine();

        int anoAtual = 2022;

        int totalDeDiasDeVida = (anoAtual - anoDeNascimento) * 365
                + mesDeNascimento * 30 + diaDoNascimento;

        System.out.println("Quantidade de dias de vida: " + totalDeDiasDeVida);



        scanner.close();

    }
}
