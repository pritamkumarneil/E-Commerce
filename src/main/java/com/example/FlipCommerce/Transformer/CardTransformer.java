package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.RequestDto.CardRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Model.Card;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardTransformer {
    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .validTill(cardRequestDto.getValidTil())
                .build();
    }
    public static CardResponseDto cardToCardResponseDto(Card card){
        return CardResponseDto.builder()
                .cardNo(card.getCardNo())
                .cardType(card.getCardType())
                .CustomerName(card.getCustomer().getName())
                .build();
    }
}
