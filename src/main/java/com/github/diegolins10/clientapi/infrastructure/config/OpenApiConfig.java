package com.github.diegolins10.clientapi.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI clientApiOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("ClientAPI")
                        .description("Documentação da API de clientes.")
                        .version("v1")
                        .contact(new Contact()
                                .name("Diego Lins")
                                .url("https://github.com/diegolins10")
                        )
                );
    }
}

