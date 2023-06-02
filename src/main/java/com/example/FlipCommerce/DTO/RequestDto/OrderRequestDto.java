package com.example.FlipCommerce.DTO.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderRequestDto {
    String customerMail;
    int productId;
    int requiredQuantity;
    String cardNo;
    int cvv;
}
