package Modulo_1.Lista_1;

import java.util.Locale;
import java.util.Scanner;

public class Ex_5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Valor da hora: ");
        double valorHora = scanner.nextDouble();

        System.out.print("Número de horas normais trabalhadas: ");
        double horasNormaisTrabalhadas = scanner.nextDouble();

        System.out.print("Número de horas extras (50%) trabalhadas: ");
        double horasExtras50Trabalhadas = scanner.nextDouble();

        System.out.print("Número de horas extras (100%) trabalhadas: ");
        double horasExtras100Trabalhadas = scanner.nextDouble();

        double salarioBruto = (horasNormaisTrabalhadas * valorHora) +
                (horasExtras50Trabalhadas * valorHora * 1.5) +
                (horasExtras100Trabalhadas * valorHora * 2);

        System.out.println("Salário bruto: " + salarioBruto + " R$.");

         scanner.close();

    }
}
