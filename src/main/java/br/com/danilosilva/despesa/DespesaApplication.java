package br.com.danilosilva.despesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DespesaApplication {
	@GetMapping
	public String getHomeTest(){
		return "Despesa Cliente - API";
	}
	public static void main(String[] args) {
		SpringApplication.run(DespesaApplication.class, args);
	}
}
