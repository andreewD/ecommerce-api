package com.ecommerce.demo.models.card;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
    @Size(min = 16, max = 19, message = "PAN must be between 16 and 19 characters")
    private String pan;
    @Size(min = 3, max = 4, message = "CVV must be between 3 and 4 characters")
    private String cvv;
    private String expirationDate;
}
