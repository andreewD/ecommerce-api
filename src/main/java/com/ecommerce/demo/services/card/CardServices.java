package com.ecommerce.demo.services.card;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.controllers.fwk.UseCaseResult;
import com.ecommerce.demo.models.card.Card;
import com.ecommerce.demo.services.card.usecases.CardValidationUseCase;
import com.ecommerce.demo.services.fwk.GenericService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CardServices implements GenericService {
    private final CardValidationUseCase cardValidationUseCase;

    public CardServices(CardValidationUseCase cardValidationUseCase) {
        this.cardValidationUseCase = cardValidationUseCase;
    }

    public CardValidationRS validateCard(Card card) {
        CardValidationRS result = new CardValidationRS();
        validate(result, card);
        if (result.hasErrors()) {
            return result;
        }
        return cardValidationUseCase.execute(card);
    }

    @Override
    public void validate(UseCaseResult result, Card classToValidate) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        jakarta.validation.Validator validator = factory.getValidator();
        Set<ConstraintViolation<Card>> violations = validator.validate(classToValidate);
        List<String> Reslist = new ArrayList<String>();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Card> violation : violations) {
                Reslist.add(violation.getMessage());
            }
        }
        result.setValidationsErrors(Reslist);
    }
}
