package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Exceptions.SellerNotFoundException;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Model.Seller;
import com.example.FlipCommerce.Repository.ProductRepository;
import com.example.FlipCommerce.Repository.SellerRepository;
import com.example.FlipCommerce.Service.ProductService;
import com.example.FlipCommerce.Transformer.ProductTransfomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller=sellerRepository.findByEmailId(productRequestDto.getSellerEmailId());
        if(seller==null){
            throw new SellerNotFoundException("Seller with given emailId doesn't exist");
        }
        Product product= ProductTransfomer.productRequestDtoToProduct(productRequestDto);
        seller.getProducts().add(product);
        product.setSeller(seller);

        Seller savedSeller=sellerRepository.save(seller);
        return ProductTransfomer.productToPoductResponseDto(savedSeller.getProducts().get(savedSeller.getProducts().size()-1));
    }
}
