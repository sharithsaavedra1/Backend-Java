package com.school.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI schoolOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("School API")
                        .description("API REST - Sistema de Colegio | Teachers, Students, Enrollments")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Tu Nombre")
                                .email("tucorreo@email.com")));
    }
}