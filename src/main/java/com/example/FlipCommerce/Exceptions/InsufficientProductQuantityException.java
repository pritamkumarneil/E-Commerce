package com.example.FlipCommerce.Exceptions;

public class InsufficientProductQuantityException extends Exception{
    public InsufficientProductQuantityException(String message){
        super(message);
    }
}
