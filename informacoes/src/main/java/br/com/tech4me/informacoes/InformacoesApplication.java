package br.com.tech4me.informacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InformacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformacoesApplication.class, args);
	}

}
