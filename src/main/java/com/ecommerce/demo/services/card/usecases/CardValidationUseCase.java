package com.ecommerce.demo.services.card.usecases;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.models.card.Card;

public class CardValidationUseCase {
    public CardValidationRS execute(Card card) {


        return CardValidationRS.builder()
                .valid(true)
                .message("Card is valid")
                .build();
    }

    private boolean validateCardNumber(String cardNumber) {
        return true;
    }

    private boolean LuhnAlgorithm(String cardNumber) {
        return true;
    }
}
