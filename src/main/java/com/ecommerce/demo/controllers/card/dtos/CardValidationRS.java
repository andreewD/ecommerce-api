package com.ecommerce.demo.controllers.card.dtos;

import com.ecommerce.demo.controllers.fwk.UseCaseResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardValidationRS extends UseCaseResult {
    private boolean valid;
    private String message;
}
