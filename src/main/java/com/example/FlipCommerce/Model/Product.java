package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enums.Category;
import com.example.FlipCommerce.Enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "price",nullable = false)
    Integer price;

    @Column(name="discount")
    Integer discount;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    Category category;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "product_status")
    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    // Navigational Properties
    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();


}
