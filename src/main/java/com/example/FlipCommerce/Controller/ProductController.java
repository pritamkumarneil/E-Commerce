package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.DTO.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("add-product")
    public ResponseEntity addProduct(@RequestBody  ProductRequestDto productRequestDto){
        try{
            ProductResponseDto product=productService.addProduct(productRequestDto);
            return new ResponseEntity(product, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
