package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SaaS User Role Permission Manager API")
                        .version("1.0")
                        .description("API for managing users, roles and permissions"))
                        .servers(List.of(
                            new Server().url("https://9276.408procr.amypo.ai/")
                        ));
    }
}