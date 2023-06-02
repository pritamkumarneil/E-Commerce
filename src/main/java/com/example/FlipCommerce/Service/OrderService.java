package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.CheckoutCartRequestDto;
import com.example.FlipCommerce.DTO.RequestDto.OrderRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.OrderResponseDto;
import com.example.FlipCommerce.Exceptions.*;

public interface OrderService {
    public OrderResponseDto checkoutCart(CheckoutCartRequestDto checkoutCartRequestDto);
    public OrderResponseDto makeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, CardNotFound, CardISExpiredException, InsufficientProductQuantityException;
}
