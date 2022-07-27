import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HomeWorkExer4 {

    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/London");

        LocalDateTime diaDoShow = LocalDateTime.parse("2024-09-14T18:30:00.000",
                DateTimeFormatter.ISO_DATE_TIME);

        LocalDateTime diaAtual = LocalDateTime.now(zone);

        // Pegar o intervalo de ano - PRINCIPAL PARTE
        long anos = diaAtual.until(diaDoShow, ChronoUnit.YEARS);
        diaAtual = diaAtual.plusYears(anos);

        // Pegar o intervalo de mês - se passar o valor é negativo então subtrai
        long meses = diaAtual.until(diaDoShow, ChronoUnit.MONTHS);
        diaAtual = diaAtual.plusMonths(meses);

        long dias = diaAtual.until(diaDoShow, ChronoUnit.DAYS);
        diaAtual = diaAtual.plusDays(dias);

        long horas = diaAtual.until(diaDoShow, ChronoUnit.HOURS);

        diaAtual = diaAtual.plusHours(horas);
        long minutos = diaAtual.until(diaDoShow, ChronoUnit.MINUTES);

        System.out.println("Anos: " + anos);
        System.out.println("Meses: " + meses);
        System.out.println("Dias: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);

    }

}

