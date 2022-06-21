package Lista_2;

/*
Faça um algoritmo que leia 20 valores e os escreva na ordem contrária à que foram
digitados.
 */

import java.util.Scanner;

public class Ex_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int TAMANHO = 20;
        int[] valores = new int[TAMANHO];

        for (int i = 0; i < TAMANHO; i ++){
            System.out.print("Número " + i +": ");
            int valorLido = scanner.nextInt();
            scanner.nextLine();
            valores[i] = valorLido;
        }

        for (int i = TAMANHO - 1; i >= 0; i--) {
            System.out.println(valores[i]);
        }

        scanner.close();
    }
}
