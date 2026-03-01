package com.github.diegolins10.clientapi.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI clientApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Client Integration API")
                        .description("Documentação da API de gerenciamento de clientes")
                        .version("v1")
                        .contact(new Contact().name("Equipe Client API"))
                        .license(new License().name("MIT")));
    }
}
