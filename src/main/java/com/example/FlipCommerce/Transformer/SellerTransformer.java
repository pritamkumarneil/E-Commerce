package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.Model.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {
    public static Seller sellerRequestDtotoSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .age(sellerRequestDto.getAge())
                .name(sellerRequestDto.getName())
                .mobNo(sellerRequestDto.getMobNo())
                .emailId(sellerRequestDto.getEmailId())
                .gender(sellerRequestDto.getGender())
                .build();
    }
    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .sellerName(seller.getName())
                .emailId(seller.getEmailId())
                .gender(seller.getGender())
                .build();
    }
}
