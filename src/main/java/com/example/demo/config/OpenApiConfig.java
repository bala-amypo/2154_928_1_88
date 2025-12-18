package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 👇 PASTE YOUR URL HERE
        Server server = new Server();
        server.setUrl("https://9110.pro604cr.amypo.ai");
        server.setDescription("Production Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Demo Application API")
                        .version("1.0")
                        .description("Swagger documentation for Users and Vehicles APIs"))
                .servers(List.of(server));
    }
}
