package com.tienda.tools;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import com.tienda.TiendaOnlineApplication;

import java.io.File;

/**
 * Ejecutable que carga el contexto de Spring (no web) y exporta el bean OpenAPI a docs/openapi.json
 */
public class OpenApiExporter {
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(TiendaOnlineApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        try (ConfigurableApplicationContext ctx = app.run(args)) {
            OpenAPI openAPI = ctx.getBean(OpenAPI.class);
            File out = new File("docs/openapi.json");
            out.getParentFile().mkdirs();
            Json.mapper().writerWithDefaultPrettyPrinter().writeValue(out, openAPI);
            System.out.println("OpenAPI exported to " + out.getAbsolutePath());
        }
    }
}

