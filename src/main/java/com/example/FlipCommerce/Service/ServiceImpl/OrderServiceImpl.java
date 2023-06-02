package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.CheckoutCartRequestDto;
import com.example.FlipCommerce.DTO.RequestDto.OrderRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.OrderResponseDto;
import com.example.FlipCommerce.Enums.OrderStatus;
import com.example.FlipCommerce.Enums.ProductStatus;
import com.example.FlipCommerce.Exceptions.*;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Order;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Repository.OrderRepository;
import com.example.FlipCommerce.Repository.ProductRepository;
import com.example.FlipCommerce.Service.OrderService;
import com.example.FlipCommerce.Service.ServiceImpl.Validation.CardValidation;
import com.example.FlipCommerce.Service.ServiceImpl.Validation.CustomerValidation;
import com.example.FlipCommerce.Service.ServiceImpl.Validation.ProductValidation;
import com.example.FlipCommerce.Transformer.ItemTransformer;
import com.example.FlipCommerce.Transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerValidation customerValidation;
    @Autowired
    CardValidation cardValidation;
    @Autowired
    ProductValidation productValidation;
    @Override
    public OrderResponseDto checkoutCart(CheckoutCartRequestDto checkoutCartRequestDto) {
        return null;
    }

    @Override
    public OrderResponseDto makeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, CardNotFound, CardISExpiredException, InsufficientProductQuantityException {

        // validating customer first;
        Customer customer;
        try{
            customer= customerValidation.validateCustomerByMail(orderRequestDto.getCustomerMail());
        }
        catch(Exception e){
            throw e;
        }
        Product product;
        try{
            product= productValidation.validateProduct(orderRequestDto.getProductId());
        }
        catch (Exception e){
            throw e;
        }
        String cardNo;
        try{
            if(cardValidation.validateCard(orderRequestDto.getCardNo(),orderRequestDto.getCvv())){
                cardNo=orderRequestDto.getCardNo();
            }
        }catch (Exception e){
            throw e;
        }
        // check if product is available in given quantity or not ?
        int requiredQuantity=orderRequestDto.getRequiredQuantity();
        if(requiredQuantity>product.getQuantity()){
            throw new InsufficientProductQuantityException("Insufficient Quantity available");
        }
        // now create item
        Item item= ItemTransformer.createItem(requiredQuantity);
        int totalAmount=((requiredQuantity * (100 - product.getDiscount())*product.getPrice())+50)/100;
        item.setTotalAmount(totalAmount);

        // update order details
        Order order= OrderTransformer.OrderRequestDtoToOrder(orderRequestDto);
        LocalDate today=LocalDate.now();
        order.setDeliveryDate(Date.valueOf(today.plusDays(5)));
        order.setOrderValue(item.getTotalAmount());
        order.getItems().add(item);
        item.setOrder(order);
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        Order savedOrder=orderRepository.save(order);// saving order entity
        Item savedItem=savedOrder.getItems().get(0);
        //make the relations between them
        product.getItems().add(savedItem);
        savedItem.setProduct(product);
        product.setQuantity(product.getQuantity()-requiredQuantity);
        if(product.getQuantity()==0) product.setProductStatus(ProductStatus.OUT_OF_STOCK);

        productRepository.save(product);

        return OrderTransformer.orderToOrderResponseDto(savedOrder);
    }

}
