package com.example.testeffectivemobile.open_api;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Task")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("p-vikulinpb@mail.ru")
                                                .name("Vikulin Pavel")
                                )
                );
    }
}
