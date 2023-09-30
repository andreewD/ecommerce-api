package com.ecommerce.demo.services.card;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.models.card.Card;
import com.ecommerce.demo.services.card.usecases.CardValidationUseCase;
import org.springframework.stereotype.Service;

@Service
public class CardServices {
    private final CardValidationUseCase cardValidationUseCase;

    public CardServices(CardValidationUseCase cardValidationUseCase) {
        this.cardValidationUseCase = cardValidationUseCase;
    }

    public CardValidationRS validateCard(Card card) {
        return cardValidationUseCase.execute(card);
    }
}
