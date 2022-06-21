package Lista_1;

import java.util.Locale;
import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Valor consumido: ");
        double valorConsumido = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Valor pago: ");
        double valorPago = scanner.nextDouble();
        scanner.nextLine();

        double troco = valorPago - valorConsumido;

        if ( troco < 0) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido");
        } else {
            System.out.println("O troco é: " + troco + " R$.");
        }

        scanner.close();

    }
}
