package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.DTO.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.Enums.ProductStatus;
import com.example.FlipCommerce.Exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.Exceptions.InsufficientProductQuantityException;
import com.example.FlipCommerce.Exceptions.ProductNotFoundException;
import com.example.FlipCommerce.Exceptions.ProductOutOfStockException;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Repository.ProductRepository;
import com.example.FlipCommerce.Service.ItemService;
import com.example.FlipCommerce.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Item addItem(ItemRequestDto itemRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientProductQuantityException, ProductOutOfStockException {
        // first check customer is valid or not
        Customer customer=customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Customer with given Email doesn't exist");
        }
        // now check if product id is valid or not
        Optional<Product> optionalProduct=productRepository.findById(itemRequestDto.getProductId());
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product Not found ");
        }
        Product product=optionalProduct.get();
        // check for sufficient quantity available or not
        if(product.getProductStatus()== ProductStatus.OUT_OF_STOCK){
            throw new ProductOutOfStockException("This Product is Out of Stock Not");
        }
        if(product.getQuantity()<itemRequestDto.getRequiredQuantity()){
            throw new InsufficientProductQuantityException("Sorry! The required Quantity is not available");
        }

        // here  we are not making bidirectional relation.. simply returning item
        // this will be done in the cart service ..
        return ItemTransformer.createItem(itemRequestDto.getRequiredQuantity());
    }
}
