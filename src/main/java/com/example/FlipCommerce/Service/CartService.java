package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Model.Item;

public interface CartService {
    public CartResponseDto addItemToCart(Item item, ItemRequestDto itemRequestDto );
}
