package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.DTO.RequestDto.OrderRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.DTO.ResponseDto.OrderResponseDto;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Order;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class OrderTransformer {
    public static Order OrderRequestDtoToOrder(OrderRequestDto orderRequestDto){

        return Order.builder()
                .orderId(UUID.randomUUID().toString())
                .cardUsed(orderRequestDto.getCardNo())
                .items(new ArrayList<>())
                .build();
    }
    public static OrderResponseDto orderToOrderResponseDto(Order order){
        List<ItemResponseDto> items=new ArrayList<>();
        for(Item item: order.getItems()){
            items.add(ItemTransformer.itemToItemResponseDto(item));
        }
        return OrderResponseDto.builder()
                .orderValue(order.getOrderValue())
                .orderStatus(order.getOrderStatus())
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .deliveryDate(order.getDeliveryDate())
                .cardUsed(order.getCardUsed())
                .items(items)
                .build();
    }
}
