package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enums.CardType;
import com.example.FlipCommerce.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "order_info")
public class Order {
    // here we cannot keep the name order because this keyword in mysql
    // so in order to avoid this conflict we can name this entity as OrderEntity/Ordered/
    // or simply Order but the table name shouldn't be order // so table name is order_info

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "order_id",unique = true,nullable = false)
    String orderId;

    @Column(name = "order_value")
    Integer orderValue;

    @Column(name = "order_date")
    @CreationTimestamp
    Date orderDate;

    @Column(name = "order_status",nullable = false)
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @Column(name = "delivery_date",nullable = false)
    Date deliveryDate;

    @Column(name = "card_used")
    String cardUsed;// it will be used to show the card number only last four digit

    // navigational properties
    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();
}
