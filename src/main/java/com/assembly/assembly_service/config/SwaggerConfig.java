package com.assembly.assembly_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Assembly Service - Rest API")
                        .description("Serviço para gerenciar pautas e sessões de votação.")
                        .version("1.0")
                )
                .components(new io.swagger.v3.oas.models.Components());
    }
}
