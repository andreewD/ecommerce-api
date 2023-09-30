package com.ecommerce.demo.configurations;

import com.ecommerce.demo.services.card.usecases.CardValidationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public CardValidationUseCase cardValidationUseCase() {
        return new CardValidationUseCase();
    }
}
