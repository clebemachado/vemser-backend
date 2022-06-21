package Lista_2;

import java.util.Locale;
import java.util.Scanner;

/*
Desenvolver um algoritmo que peça nome, altura, idade, peso dos jogadores de
basquete, enquanto o nome do jogador for diferente da palavra SAIR o programa
deverá pedir essas informações, após cadastrados deverá aparecer as seguintes
informações:
    * Quantidade de jogadores cadastrados;
    * Altura do maior Jogador;
    * Jogador mais velho;
    * Jogador mais pesado;
    * Média das alturas jogadores.
 */

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        int cont = 0;
        double maiorAltura = 0;
        int idadeJogadorVelho = 0;
        String nomeJogadorMaisVelho = "";
        String nomeJogadorMaisPesado = "";
        double jogadorMaiorPeso = 0;
        double somaAlturaDosJogadores = 0;

        while (true){
            System.out.print("Nome do jogador: ");
            String nome = scanner.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                break;
            }

            System.out.print("Altura do jogador: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Idade do jogador: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Peso do jogador: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            System.out.println();

            if(altura > maiorAltura) maiorAltura = altura;
            if(peso > jogadorMaiorPeso){
                nomeJogadorMaisPesado = nome;
                jogadorMaiorPeso = peso;
            }
            if(idade > idadeJogadorVelho){
                nomeJogadorMaisVelho = nome;
                idadeJogadorVelho = idade;
            }

            somaAlturaDosJogadores += altura;
            cont += 1;
        }

        if(cont != 0){
            double mediaAltura = somaAlturaDosJogadores / cont;
            System.out.println("Quantidade de jogadores cadastrados: " + cont);
            System.out.println("Altura do maior Jogador: " + maiorAltura);
            System.out.println("Jogador mais velho: " + nomeJogadorMaisVelho);
            System.out.println("Jogador mais pesado: " + nomeJogadorMaisPesado);
            System.out.println("Média das alturas jogadores: " + mediaAltura);
        }

    }
}
