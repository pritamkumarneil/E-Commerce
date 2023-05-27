package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.DTO.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.Exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.Exceptions.InsufficientProductQuantityException;
import com.example.FlipCommerce.Exceptions.ProductNotFoundException;
import com.example.FlipCommerce.Exceptions.ProductOutOfStockException;
import com.example.FlipCommerce.Model.Item;

public interface ItemService {
    public Item addItem(ItemRequestDto itemRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientProductQuantityException, ProductOutOfStockException;
}
