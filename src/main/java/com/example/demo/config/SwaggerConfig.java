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
        return new OpenAPI()
                .info(new Info()
                        .title("Demo Application API")
                        .description("Apartment, Facility, Booking Management APIs")
                        .version("1.0.0"))
                .servers(List.of(
                        new Server()
                                .url("https://9110.pro604cr.amypo.ai")
                                .description("Production Server")
                ));
    }
}
