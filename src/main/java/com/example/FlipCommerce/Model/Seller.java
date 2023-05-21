package com.example.FlipCommerce.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seller")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
// @SuperBuilder
public class Seller extends Person {

    // Navigational Properties
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> products=new ArrayList<>();
}
