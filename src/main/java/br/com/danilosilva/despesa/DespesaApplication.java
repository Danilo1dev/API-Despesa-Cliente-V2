package br.com.danilosilva.despesa;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@Log4j2
public class DespesaApplication {
	@GetMapping
	public String getHomeTest(){
	log.info("[start] - Pagina Home acessada");
		return "Despesa Pessoa - API";
	}
	public static void main(String[] args) {
		SpringApplication.run(DespesaApplication.class, args);
	}
}
