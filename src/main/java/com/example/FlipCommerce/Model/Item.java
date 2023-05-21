package com.example.FlipCommerce.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "item")
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "required_quantity")
    int requiredQuantity;

    // navigational properties
    @ManyToOne
    @JoinColumn
    Product product;

    @ManyToOne
    @JoinColumn
    Order order;

    @ManyToOne
    @JoinColumn
    Cart cart;
}
