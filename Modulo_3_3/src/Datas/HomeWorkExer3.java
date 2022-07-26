package Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class HomeWorkExer3 {
    public static void main(String[] args) {

        LocalDateTime dateNow = LocalDateTime.now();
        dateNow = dateNow.plusDays(15);
        dateNow = dateNow.plusHours(10);

        System.out.println("Dia da semana: " + dateNow.getDayOfWeek());
        System.out.println("Dia da semana: " + dateNow.getDayOfYear());

    }

}
