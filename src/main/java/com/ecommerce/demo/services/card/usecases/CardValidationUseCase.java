package com.ecommerce.demo.services.card.usecases;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.controllers.fwk.StatusCode;
import com.ecommerce.demo.models.card.Card;

public class CardValidationUseCase {
    public CardValidationRS execute(Card card) {

        CardValidationRS result = new CardValidationRS();
        result.setValid(validateCardNumber(card.getPan()));
        result.setStatusCode(result.isValid() ? StatusCode.SUCCESS : StatusCode.ERROR);
        result.setMessage(result.isValid() ? "Card is valid" : "Card is invalid");
        return result;
    }

    private boolean validateCardNumber(String cardNumber) {
        return true;
    }

    private boolean LuhnAlgorithm(String cardNumber) {
        return true;
    }
}
