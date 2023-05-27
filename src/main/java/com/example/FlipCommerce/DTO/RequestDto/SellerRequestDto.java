package com.example.FlipCommerce.DTO.RequestDto;

import com.example.FlipCommerce.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerRequestDto {

    String name;
    String emailId;
    String mobNo;
    int age;
    Gender gender;
}
