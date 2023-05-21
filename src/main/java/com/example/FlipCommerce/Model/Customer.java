package com.example.FlipCommerce.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.swing.text.StyleContext;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer")
@Builder
//@SuperBuilder
public class Customer extends Person{

    //navigational properties
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cards=new ArrayList<>();

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();

}
