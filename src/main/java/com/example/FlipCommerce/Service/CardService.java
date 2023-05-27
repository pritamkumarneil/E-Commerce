package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.CardRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Exceptions.CustomerNotFoundException;

public interface CardService {
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;
}
