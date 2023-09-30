package com.ecommerce.demo.controllers.card;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRQ;
import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.services.card.CardServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.demo.controllers.converters.DtoToDboConverter;

@RestController
public class CardController {
    private final CardServices cardServices;

    public CardController(CardServices cardServices) {
        this.cardServices = cardServices;
    }
    @Operation(summary = "Validate card")
    @PostMapping("/card/validate")
    public CardValidationRS validateCard(@RequestBody CardValidationRQ cardValidationRQ) {
        return cardServices.validateCard(DtoToDboConverter.MAPPER.convert(cardValidationRQ));
    }
}
