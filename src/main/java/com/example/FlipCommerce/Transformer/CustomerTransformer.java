package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.Model.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerTransformer {
    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .age(customerRequestDto.getAge())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId())
                .gender(customerRequestDto.getGender())
                .name(customerRequestDto.getName())
                .build();
    }
    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .build();
    }
}
