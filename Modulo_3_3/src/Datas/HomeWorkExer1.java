package Datas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeWorkExer1 {

    public static LocalDate getDateUser(){

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate userData;

        while (true){
            System.out.print("Informe a data(dd/MM/yyyy): ");
            String dataUser = scanner.nextLine();
            userData = LocalDate.parse(dataUser, formatter);
            if(userData.getYear() > LocalDate.now().getYear()){
                System.out.println("Ano inválido, tente novamente.");
            } else {
                break;
            }
        }

        scanner.close();
        return userData;
    }


    public static void main(String[] args) {

        LocalDate niverUser = getDateUser();
        LocalDate hojeData = LocalDate.now();

        boolean mesIgualAtualEDiaAntesDoDiaAtual =
                niverUser.getMonthValue() == hojeData.getMonthValue()
                        && niverUser.getDayOfMonth() < hojeData.getDayOfMonth();

        boolean mesEhAntesDoAtual = niverUser.getMonthValue() < hojeData.getMonthValue();

        int novoAno = mesIgualAtualEDiaAntesDoDiaAtual || mesEhAntesDoAtual
                ? hojeData.getYear() + 1
                : hojeData.getYear();

        LocalDate dataNoFuturo = LocalDate.of(novoAno, niverUser.getMonthValue(),
                niverUser.getDayOfMonth());

        Period period = Period.between(hojeData, dataNoFuturo);

        System.out.println(period.getMonths() + " meses e "
                + period.getDays() + "dias para seu aniversário");
    }
}
