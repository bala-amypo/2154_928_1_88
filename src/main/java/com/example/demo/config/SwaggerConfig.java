package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bookingAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Apartment Facility Booking API")
                        .description("API Docs for Facility Booking System")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your-email@example.com")
                                .url("https://example.com")));
    }
}
