package Modulo_1.Lista_2;

import java.util.Random;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int valorAleatorio = new Random().nextInt(1000);

        int valorUser;
        System.out.println(valorAleatorio);
        while (true){
            System.out.print("Entre com um valor: ");
            valorUser = scanner.nextInt();
            scanner.nextLine();

            if(valorAleatorio > valorUser){
                System.out.println("número a ser encontrado é maior do que você digitou.");
            } else if(valorAleatorio < valorUser){
                System.out.println("O número a ser encontrado é menor do que você digitou.");
            } else {
                System.out.println("Opa! esse é o valor.");
                break;
            }
        }

    }
}