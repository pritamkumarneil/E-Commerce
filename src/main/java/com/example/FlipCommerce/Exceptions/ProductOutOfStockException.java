package com.example.FlipCommerce.Exceptions;

public class ProductOutOfStockException extends Exception{
    public ProductOutOfStockException(String message){
        super(message);
    }
}
