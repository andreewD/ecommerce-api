package com.ecommerce.demo.models.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
    private String pan;
    private String cvv;
    private String expirationDate;
}
