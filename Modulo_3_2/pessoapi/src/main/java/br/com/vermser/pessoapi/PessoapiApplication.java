package br.com.vermser.pessoapi;

import br.com.vermser.pessoapi.enums.TipoContato;
import br.com.vermser.pessoapi.enums.TipoEndereco;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class PessoapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PessoapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(TipoEndereco tipoEnd: TipoEndereco.values()){
			System.out.println(tipoEnd + ": " + tipoEnd.ordinal() + " ");
		}
		System.out.println();
		for (TipoEndereco tipoEnd : TipoEndereco.values()) {
			System.out.println("Nome: " + tipoEnd  + " : " + tipoEnd.getTipo() );
			System.out.println(TipoEndereco.ofTipo(tipoEnd.getTipo()));
		}
	}
}
