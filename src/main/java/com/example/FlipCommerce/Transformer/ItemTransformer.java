package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemTransformer {
    public static ItemResponseDto itemToItemResponseDto(Item item){
        return ItemResponseDto.builder()
                .quantityAdded(item.getRequiredQuantity())
                .product(ProductTransfomer.productToPoductResponseDto(item.getProduct()))
                .build();
    }
    public static Item createItem(int quantity){
        return Item.builder()
                .requiredQuantity(quantity)
                .build();
    }
}
