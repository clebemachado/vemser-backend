package Lista_1;

import java.util.Scanner;

public class Ex_6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Palavra para ser traduzida: ");
        String palavra = scanner.nextLine().toLowerCase();
        String palavraTraduzida;

        switch (palavra){
            case "cachorro":
            case "dog":
                palavraTraduzida = palavra.equals("dog") ? "Cachorro" : "Dog";
                break;
            case "tempo":
            case "time":
                palavraTraduzida = palavra.equals("time") ? "Tempo" : "Time";
                break;
            case "amor":
            case "love":
                palavraTraduzida = palavra.equals("love") ? "Amor" : "Love";
                break;
            case "cidade":
            case "city":
                palavraTraduzida = palavra.equals("city") ? "Cidade" : "City";
                break;
            case "feliz":
            case "happy":
                palavraTraduzida = palavra.equals("happy") ? "Feliz" : "Happy";
                break;
            case "triste":
            case "sad":
                palavraTraduzida = palavra.equals("sad") ? "Triste" : "Sad";
                break;
            case "deveria":
            case "shoud":
                palavraTraduzida = palavra.equals("shoud") ? "Deveria" : "Shoud";
                break;
            case "poderia":
            case "could":
                palavraTraduzida = palavra.equals("could") ? "Poderia" : "Could";
                break;
            default:
                System.out.println("Essa palavra não é válida.");
                return;
        }

        System.out.println("Tradução: " + palavraTraduzida);

        scanner.close();

    }
}
