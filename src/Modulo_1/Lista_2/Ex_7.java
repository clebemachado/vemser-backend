package Modulo_1.Lista_2;

import java.util.Scanner;

/*
Leia uma matriz 4 x 4, conte e escreva quantos valores maiores que 10 ela possui
 */
public class Ex_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrizNumeros = new int[4][4];

        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j ++){
                matrizNumeros[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        int contador = 0;
        for (int[] matrizes:matrizNumeros) {
            for(int valores: matrizes){
                if(valores >= 10){
                    contador += 1;
                }
            }
        }

        System.out.println("Quantidade de valores maiores que 10: " + contador);

    }
}
