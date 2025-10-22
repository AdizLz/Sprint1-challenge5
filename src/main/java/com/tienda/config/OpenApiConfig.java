package com.tienda.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tienda Online API")
                        .version("v1")
                        .description("API para gestionar órdenes en la tienda online")
                        .contact(new Contact().name("Equipo Tienda").email("dev@tienda.local")))
                .servers(List.of(new Server().url("/").description("Servidor local")));
    }
}

