package com.example.FlipCommerce.DTO.ResponseDto;

import com.example.FlipCommerce.Enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {
    String CustomerName;
    String cardNo;
    CardType cardType;
}
