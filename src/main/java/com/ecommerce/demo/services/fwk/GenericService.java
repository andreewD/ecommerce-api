package com.ecommerce.demo.services.fwk;

import com.ecommerce.demo.controllers.fwk.UseCaseResult;
import com.ecommerce.demo.models.card.Card;

public interface GenericService {
    void validate(UseCaseResult result, Card classToValidate);
}
