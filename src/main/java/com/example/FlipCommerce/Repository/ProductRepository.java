package com.example.FlipCommerce.Repository;

import com.example.FlipCommerce.Enums.Category;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategoryAndPrice(Category category, int price);
}
