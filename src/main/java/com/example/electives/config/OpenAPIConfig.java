package com.example.electives.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Info info = new Info()
                .title("Elective Service API")
                .version("1.0")
                .description("Этот API предоставляет конечные точки для управления элективами и преподавателями");

        return new OpenAPI().info(info);
    }

}
