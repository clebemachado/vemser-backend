package Modulo_1.Lista_2;
/*
Faça um programa que leia uma matriz de 5x4 inteiros contendo as seguintes
informações do tipo inteiro:
    * a. Primeira coluna: número da matrícula
    * b. Segunda coluna: media das provas
    * c. Terceira coluna: média dos trabalhos
    * d. Quarta coluna: nota final
Elabore um programa que:
    * a. Leia as 3 primeiras informações de cada aluno
    * b. Calcule a nota final = (media das provas * 0,6 + media dos trabalhos * 0,4)
    * c. Imprima a matrícula que obteve a maior nota final
    * d. Imprima a média das notas finais

 */

import java.util.Locale;
import java.util.Scanner;

public class Ex_8 {
    public static void main(String[] args) {
        // faz mais sentido a matriz ser double

        double[][] escolas = new double[5][4];
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        double mediaDasProvas = 0;
        double mediaDosTrabalhos = 0;

        for (int i = 0; i < escolas.length; i++) {
            for (int j = 0; j < escolas[0].length; j++) {
                if(j == 0){
                    System.out.print("Número da matrícula: ");
                    escolas[i][j] = scanner.nextDouble();
                    scanner.nextLine();
                } else if(j == 1){
                    System.out.print("Media das provas: ");
                    mediaDasProvas = scanner.nextDouble();
                    escolas[i][j] = mediaDasProvas;
                    scanner.nextLine();
                } else if(j == 2){
                    System.out.print("Média dos trabalhos: ");
                    mediaDosTrabalhos = scanner.nextDouble();
                    escolas[i][j] = mediaDosTrabalhos;
                    scanner.nextLine();
                } else {
                    double notaFinal = mediaDasProvas * 0.6 + mediaDosTrabalhos * 0.4;
                    escolas[i][j] = notaFinal;
                }
            }
            System.out.println();
        }

        double maiorNotaFinal = 0;
        double sumNotaFinal = 0;
        double matriculaComMaiorNotaFinal = 0;

        for (int i = 0; i < escolas.length; i++) {
            sumNotaFinal += escolas[i][3];
            if ( i == 0){
                maiorNotaFinal = escolas[i][3];
                matriculaComMaiorNotaFinal = escolas[i][0];
            } else {
                if(escolas[i][3] > maiorNotaFinal){
                    maiorNotaFinal = escolas[i][3];
                    matriculaComMaiorNotaFinal = escolas[i][0];
                }
            }
        }

        System.out.println("Matrícula que obteve a maior nota final: "
                + (int) matriculaComMaiorNotaFinal + ". Média: "
                + maiorNotaFinal * 100.0 / 100.0);

        sumNotaFinal = sumNotaFinal / escolas.length;
        System.out.println("Média das notas finais: " + sumNotaFinal * 100.0 / 100.0);

        scanner.close();
    }
}
