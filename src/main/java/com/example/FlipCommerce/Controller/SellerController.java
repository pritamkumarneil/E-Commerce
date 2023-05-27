package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.DTO.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("add")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        try{
            SellerResponseDto seller=sellerService.addSeller(sellerRequestDto);
            return new ResponseEntity(seller, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
