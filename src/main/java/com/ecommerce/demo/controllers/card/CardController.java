package com.ecommerce.demo.controllers.card;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRQ;
import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.services.card.CardServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> validateCard(@RequestBody CardValidationRQ cardValidationRQ) {
        CardValidationRS result = cardServices.validateCard(DtoToDboConverter.MAPPER.convert(cardValidationRQ));
        if (result.wasSuccessful()){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
