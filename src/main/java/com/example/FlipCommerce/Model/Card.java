package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enums.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "card_no",unique = true,nullable = false)
    String cardNo;

    @Column(name = "cvv",nullable = false)
    int cvv;

    @Column(name = "card_type",nullable = false)
    @Enumerated(EnumType.STRING)
    CardType cardType;

    @Column(name = "valid_till",nullable = false)
    Date validTill;

    //Navigational Properties
    @ManyToOne
    @JoinColumn
    Customer customer;

}
