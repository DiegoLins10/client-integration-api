package com.github.diegolins10.clientapi.infrastructure.config;

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
                        .title("ClientAPI")
                        .description("Documentacao OpenAPI da API de gerenciamento de clientes.")
                        .version("v1")
                        .contact(new Contact()
                                .name("Diego Lins")
                                .url("https://github.com/DiegoLins10"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
