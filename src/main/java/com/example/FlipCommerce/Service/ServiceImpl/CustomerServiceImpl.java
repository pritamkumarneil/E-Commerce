package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Service.CustomerService;
import com.example.FlipCommerce.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer= CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);
        // cart should be assigned empty also
        Cart cart= Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);
        Customer savedCustomer=customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
    }

}
