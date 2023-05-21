package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CustomerResponseDto;

public interface CustomerService {
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);
}
