package com.example.FlipCommerce.DTO.RequestDto;

import com.example.FlipCommerce.Enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardRequestDto {
    String customerEmail;
    int cvv;
    String cardNo;
    CardType cardType;
    Date validTil;
}
