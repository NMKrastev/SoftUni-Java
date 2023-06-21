package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    Optional<List<Shampoo>> findAllByBrand(String brand);

    Optional<List<Shampoo>> findByBrandAndSize(String brand, Size size);

    Optional<List<Shampoo>> findBySizeOrderById(Size size);

    Optional<List<Shampoo>> findAllBySizeOrLabelIdOrderByPrice(Size size, Long label);

    Optional<List<Shampoo>> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

}
