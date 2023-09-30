package com.ecommerce.demo.controllers.converters;

import com.ecommerce.demo.controllers.card.dtos.CardValidationRQ;
import com.ecommerce.demo.models.card.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DtoToDboConverter {
    DtoToDboConverter MAPPER = Mappers.getMapper(DtoToDboConverter.class);
    Card convert(CardValidationRQ dto);
}
