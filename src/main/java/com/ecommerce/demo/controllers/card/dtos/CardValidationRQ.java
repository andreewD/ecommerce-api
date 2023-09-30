package com.ecommerce.demo.controllers.card.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardValidationRQ {
    private String pan;
    private String cvv;
    private String expirationDate;
}