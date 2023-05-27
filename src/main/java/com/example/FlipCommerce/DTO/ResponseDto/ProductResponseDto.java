package com.example.FlipCommerce.DTO.ResponseDto;

import com.example.FlipCommerce.Enums.Category;
import com.example.FlipCommerce.Enums.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {
    String productName;
    String sellerName;
    int price;
    Category category;
    ProductStatus productStatus;
}
