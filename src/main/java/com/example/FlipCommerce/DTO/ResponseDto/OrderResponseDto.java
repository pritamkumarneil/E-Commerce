package com.example.FlipCommerce.DTO.ResponseDto;

import com.example.FlipCommerce.Enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {

    String orderId;

    Integer orderValue;

    Date orderDate;

    OrderStatus orderStatus;

    Date deliveryDate;

    String cardUsed;
    List<ItemResponseDto> items=new ArrayList<>();
}
