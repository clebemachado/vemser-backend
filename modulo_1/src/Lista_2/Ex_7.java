package Lista_2;

/*
Leia uma matriz 4 x 4, conte e escreva quantos valores maiores que 10 ela possui
 */
public class Ex_7 {
    public static void main(String[] args) {

        int[][] matrizNumeros = {
                {1, 2, 3, 4},
                {5, 6, 17, 18},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

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
