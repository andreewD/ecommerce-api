package com.ecommerce.demo;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRS;
import com.ecommerce.demo.models.card.Card;
import com.ecommerce.demo.services.card.CardMessages;
import com.ecommerce.demo.services.card.CardServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {
	private final CardServices cardServices = mock(CardServices.class);

	@Test
	void contextLoads() {
	}

	@Test
	void testCardValidation() {
		Card card = Card.builder()
				.pan("1234567890123456")
				.cvv("123")
				.expirationDate("12/21")
				.build();

		CardValidationRS cardValidationRS = new CardValidationRS();
		cardValidationRS.setValid(false);
		List<String> validationsErrors = List.of(CardMessages.PAN_INVALID, CardMessages.EXPIRATION_DATE_INVALID);
		cardValidationRS.setValidationsErrors(validationsErrors);

		when(cardServices.validateCard(card)).thenReturn(cardValidationRS);

		assert(!cardServices.validateCard(card).isValid());
		assertTrue(cardServices.validateCard(card).getValidationsErrors().contains(CardMessages.PAN_INVALID));
		assertTrue(cardServices.validateCard(card).getValidationsErrors().contains(CardMessages.EXPIRATION_DATE_INVALID));
	}

}
