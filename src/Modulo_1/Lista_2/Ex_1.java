package Modulo_1.Lista_2;

import java.util.Locale;
import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Produto.: ");
        String produto = scanner.nextLine();

        System.out.print("Preço.: ");
        double preco = scanner.nextDouble();
        System.out.println(".................");

        for (int i = 0; i < 10; i++) {

            int qtd = i + 1;

            double precoComPromocao = preco - preco * qtd * 0.05;
            precoComPromocao = Math.round(precoComPromocao * 100.0) / 100.0;

            double valorTotal =precoComPromocao * qtd;
            valorTotal = Math.round(valorTotal * 100.0) / 100.0;

            System.out.println(qtd + " x R$ " + precoComPromocao + " = R$ " + valorTotal);
        }

        scanner.close();
    }
}
