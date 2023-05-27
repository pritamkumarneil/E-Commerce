package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.DTO.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Service.CartService;
import com.example.FlipCommerce.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;
    @PostMapping("add/item")
    public ResponseEntity addItemToCart(@RequestBody ItemRequestDto itemRequestDto){
        try{
            Item item=itemService.addItem(itemRequestDto);
            CartResponseDto cart=cartService.addItemToCart(item,itemRequestDto);
            return new ResponseEntity(cart,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
