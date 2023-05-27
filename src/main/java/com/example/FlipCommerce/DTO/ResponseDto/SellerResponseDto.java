package com.example.FlipCommerce.DTO.ResponseDto;

import com.example.FlipCommerce.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerResponseDto {
    String sellerName;
    String emailId;
    Gender gender;
    String message;
}
