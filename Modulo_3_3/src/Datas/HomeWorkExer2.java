package Datas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeWorkExer2 {

    public static Scanner scanner = new Scanner(System.in);

    public static LocalDate getDateUser(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate userData;
        System.out.print("Informe a data(dd/MM/yyyy): ");
        String dataUser = scanner.nextLine();
        userData = LocalDate.parse(dataUser, formatter);
        return userData;
    }

    public static void main(String[] args) {
        LocalDate primeiraData = getDateUser();
        LocalDate segundaData = getDateUser();
        scanner.close();

        Period period;

        if(primeiraData.isAfter(segundaData)){
            period = Period.between(segundaData, primeiraData);
        } else {
            period = Period.between(primeiraData, segundaData);
        }

        System.out.println("Diferença de anos: " + period.getYears());
        System.out.println("Diferença de meses: " + period.getMonths());
        System.out.println("Diferença de dias: " + period.getDays());


    }
}
