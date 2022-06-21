package Modulo_1.Lista_2;

import java.util.Scanner;

/*
Desenvolver um algoritmo que peça três números e informe a posição do menor
número digitado (usar vetor)
 */
public class Ex_4 {
    public static void main(String[] args) {
        int[] numeros = new int[3];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i ++){
            System.out.print("Número " + i + 1+ ": ");
            numeros[i] = scanner.nextInt();
        }

        int menor = 0;
        int posicaoMenor = 0;

        for(int i = 0; i < 3; i ++){
            if(i == 0){
                menor = numeros[i];
            } else {
                if(menor > numeros[i]){
                    menor = numeros[i];
                    posicaoMenor = i;
                };
            }
        }

        System.out.println("A posição do menor número digitado é: " + posicaoMenor);

        scanner.close();

    }
}
