package com.example.FlipCommerce.Service.ServiceImpl.Validation;

import com.example.FlipCommerce.Exceptions.CardISExpiredException;
import com.example.FlipCommerce.Exceptions.CardNotFound;
import com.example.FlipCommerce.Model.Card;
import com.example.FlipCommerce.Repository.CardRepository;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CardValidation {
    @Autowired
    private  CardRepository cardRepository;
    public boolean validateCard(String cardNo,int cvv) throws CardISExpiredException, CardNotFound {
        Card card=cardRepository.findByCardNo(cardNo);
        if(card==null)
            throw new CardNotFound("Card is not Registered");
        java.util.Date utilDate=new java.util.Date();
        Date today=new Date(utilDate.getTime());
        if(today.compareTo(card.getValidTill())>0)
            throw new CardISExpiredException("The Card is Expired");
        return card.getCvv()==cvv;
    }
}
