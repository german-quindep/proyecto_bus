package com.example.backend_boleteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.backend_boleteria.Shared.Config.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class)
public class BackendBoleteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBoleteriaApplication.class, args);
	}

}
