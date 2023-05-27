package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Enums.ProductStatus;
import com.example.FlipCommerce.Model.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductTransfomer {
    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .category(productRequestDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
    public static ProductResponseDto productToPoductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getName())
                .category(product.getCategory())
                .sellerName(product.getSeller().getName())
                .price(product.getPrice())
                .productStatus(product.getProductStatus())
                .build();
    }
}
