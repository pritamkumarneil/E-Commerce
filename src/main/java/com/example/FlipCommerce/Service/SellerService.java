package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.SellerResponseDto;

public interface SellerService {
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto);
}
