package com.ecommerce.demo.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {
        @Server(url = "/", description = "Default Server URL"),
        @Server(url = "https://ecommerce-api-production-1642.up.railway.app", description = "Prod server URL")
})
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info( new Info()
                        .title("Ecommerce API")
                        .description("Ecommerce API for the Ecommerce App")
                        .version("1.0.0")
                );
    }
}
