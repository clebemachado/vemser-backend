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
public class PessoapiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PessoapiApplication.class, args);
	}

}
