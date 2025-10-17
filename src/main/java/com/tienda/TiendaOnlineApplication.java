package com.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class TiendaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaOnlineApplication.class, args);
	}

	@Bean
	public ApplicationRunner validateProdEnv(Environment env) {
		return args -> {
			if (Arrays.asList(env.getActiveProfiles()).contains("prod")) {
				String url = env.getProperty("spring.datasource.url");
				String user = env.getProperty("spring.datasource.username");
				if (url == null || url.isBlank()) {
					throw new IllegalStateException("[CONFIGURATION ERROR] En perfil 'prod' la propiedad 'spring.datasource.url' no está definida. Establezca SPRING_DATASOURCE_URL en el entorno de despliegue.");
				}
				if (user == null || user.isBlank()) {
					throw new IllegalStateException("[CONFIGURATION ERROR] En perfil 'prod' la propiedad 'spring.datasource.username' no está definida. Establezca SPRING_DATASOURCE_USERNAME en el entorno de despliegue.");
				}
			}
		};
	}

}
