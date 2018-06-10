package br.com.cwi.treinamento.worldcupapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class WorldcupApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldcupApiApplication.class, args);
	}
}
