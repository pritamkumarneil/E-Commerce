package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.Exceptions.InsufficientProductQuantityException;
import com.example.FlipCommerce.Exceptions.ProductNotFoundException;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Repository.CartRepository;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Repository.ProductRepository;
import com.example.FlipCommerce.Service.CartService;
import com.example.FlipCommerce.Transformer.CartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public CartResponseDto addItemToCart(Item item,ItemRequestDto itemRequestDto ){

        Customer customer=customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        Product product=productRepository.findById(itemRequestDto.getProductId()).get();

        Cart cart=customer.getCart();

        cart.setCartTotal(cart.getCartTotal() + item.getRequiredQuantity()*product.getPrice());

        // make relationship between item and cart
        cart.getItems().add(item);
        item.setCart(cart);
        item.setProduct(product);
        Cart savedCart=cartRepository.save(cart);
        // make the relation between product and item


        // this is to avoid item getting saved twice
        Item savedItem=savedCart.getItems().get(savedCart.getItems().size()-1);
        product.getItems().add(savedItem);
        // here if items get saved twice

        return CartTransformer.cartToCartResponseDto(savedCart);
    }
}
