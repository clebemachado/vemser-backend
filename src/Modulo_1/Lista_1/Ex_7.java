package Modulo_1.Lista_1;

public class Ex_7 {

    public static void main(String[] args) {
        int A = 10;
        int B = 20;

        System.out.println("Valor inicial de A: " + A);
        System.out.println("Valor inicial de B: " + B + "\n");

        int valorTemporarioDeA = A;

        A = B;
        B = valorTemporarioDeA;

        System.out.println("Valor final de A: " + A);
        System.out.println("Valor final de B: " + B);

    }
}
