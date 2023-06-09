package com.example.FlipCommerce.Repository;

import com.example.FlipCommerce.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByEmailId(String email);
    public Customer findByMobNo(String mobNo);
}
