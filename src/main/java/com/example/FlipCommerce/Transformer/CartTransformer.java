package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.DTO.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Item;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class CartTransformer {
    public static CartResponseDto cartToCartResponseDto(Cart cart){
        CartResponseDto cartResponseDto=CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(new ArrayList<>())
                .build();
        for(Item item : cart.getItems()){
            cartResponseDto.getItems().add(ItemTransformer.itemToItemResponseDto(item));
        }
        return cartResponseDto;
    }
}
