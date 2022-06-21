package Modulo_1.Lista_1;

import java.util.Locale;
import java.util.Scanner;

public class Ex_8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Base do retângulo: ");
        double base = scanner.nextDouble();

        System.out.print("Altura do retângulo: ");
        double alutra = scanner.nextDouble();

        double areaDoRetangulo = base * alutra;

        System.out.println("Área do retângulo: " + areaDoRetangulo + "m.");

        scanner.close();

    }
}
