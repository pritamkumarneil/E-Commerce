package com.example.FlipCommerce.DTO.RequestDto;

import com.example.FlipCommerce.Enums.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequestDto {
    String sellerEmailId;
    String name;
    Category category;
    int price;
    int quantity;

}
