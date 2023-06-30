package com.example.A1_ProductShop.repositories;

import com.example.A1_ProductShop.entities.Product;
import com.example.A1_ProductShop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal minRange, BigDecimal maxRange);
}
