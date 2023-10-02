package com.ecommerce.demo.services.card.usecases;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.controllers.fwk.StatusCode;
import com.ecommerce.demo.models.card.Card;
import com.ecommerce.demo.services.card.CardMessages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardValidationUseCase {
    public CardValidationRS execute(Card card) {
        CardValidationRS result = new CardValidationRS();
        boolean isValid;

        isValid = validateCardNumber(card.getPan());
        if (!isValid) {
            result.setValid(false);
            result.setStatusCode(StatusCode.ERROR);
            result.setMessage(CardMessages.PAN_INVALID);
            return result;
        }

        isValid = validateCVV(card.getPan(), card.getCvv());
        if (!isValid) {
            result.setValid(false);
            result.setStatusCode(StatusCode.ERROR);
            result.setMessage(CardMessages.CVV_INVALID);
            return result;
        }

        isValid = validateExpirationDate(card.getExpirationDate());
        if (!isValid) {
            result.setValid(false);
            result.setStatusCode(StatusCode.ERROR);
            result.setMessage(CardMessages.EXPIRATION_DATE_INVALID);
            return result;
        }

        result.setValid(isValid);
        result.setStatusCode(StatusCode.SUCCESS);
        return result;
    }

    private boolean validateCardNumber(String cardNumber) {
        int nDigits = cardNumber.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int d = cardNumber.charAt(i) - '0';

            if (isSecond) d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

    private boolean validateExpirationDate(String expirationDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
            LocalDate dateFormatted = LocalDate.parse(expirationDate, formatter);

            // Check if the expiration date is not in the past
            LocalDate currentDate = LocalDate.now();
            return !dateFormatted.isBefore(currentDate);
        } catch (Exception e) {
            // Invalid date format or parsing error
            return false;
        }
    }

    private boolean validateCVV(String cardNumber, String cvv) {
        int nDigits = cardNumber.length();
        if (nDigits == 16) {
            return cvv.length() == 3;
        } else if (nDigits == 19 && (cardNumber.startsWith("34") || cardNumber.startsWith("37"))) {
            return cvv.length() == 4;
        }
        return false;
    }

}
