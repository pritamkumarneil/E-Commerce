package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "Age",nullable = false)
    int age;

    @Column(name = "email_id",nullable = false,unique = true)
    String emailId;

    @Column(name = "mob_no",nullable = false,unique = true)
    String mobNo;

    @Column(name="gender",nullable = false)
    @Enumerated(EnumType.STRING)
    Gender gender;
}
