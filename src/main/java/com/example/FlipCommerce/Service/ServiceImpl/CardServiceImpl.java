package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.CardRequestDto;
import com.example.FlipCommerce.DTO.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.Model.Card;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Repository.CardRepository;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Service.CardService;
import com.example.FlipCommerce.Transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        String customerEmail=cardRequestDto.getCustomerEmail();
        Customer customer=customerRepository.findByEmailId(customerEmail);
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist with given Email Id");
        }
        Card card= CardTransformer.cardRequestDtoToCard(cardRequestDto);
        customer.getCards().add(card);
        card.setCustomer(customer);
        customerRepository.save(customer);
        return CardTransformer.cardToCardResponseDto(customer.getCards().get(customer.getCards().size()-1));
    }
}
