package com.example.FlipCommerce.Service.ServiceImpl.Validation;

import com.example.FlipCommerce.Exceptions.ProductNotFoundException;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Repository.ProductRepository;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductValidation {
    @Autowired
    private ProductRepository productRepository;
    public Product  validateProduct(int id) throws ProductNotFoundException {
        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product id is Invalid");
        }
        return productOptional.get();

    }
}
