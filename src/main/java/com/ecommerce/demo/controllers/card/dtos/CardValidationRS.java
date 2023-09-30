package com.ecommerce.demo.controllers.card.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardValidationRS {
    private boolean valid;
    private String message;
}
