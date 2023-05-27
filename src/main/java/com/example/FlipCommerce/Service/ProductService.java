package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Exceptions.SellerNotFoundException;

public interface ProductService {
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;
}
