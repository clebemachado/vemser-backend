
import java.util.Scanner;

/*
Leia uma matriz 4 x 4, conte e escreva quantos valores maiores que 10 ela possui
 */
public class Ex_7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrizNumeros = new int[4][4];

        int contador = 0;
        int valoresDigitados = 0;

        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j ++){
                valoresDigitados = scanner.nextInt();
                matrizNumeros[i][j] = valoresDigitados;
                scanner.nextLine();
                if(valoresDigitados >= 10){
                    contador += 1;
                }
            }
        }

        System.out.println("Quantidade de valores maiores que 10: " + contador);
    }
}
