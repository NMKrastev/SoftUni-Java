package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    Optional<List<Shampoo>> findAllByBrand(String brand);

    Optional<List<Shampoo>> findByBrandAndSize(String brand, Size size);

    Optional<List<Shampoo>> findBySizeOrderById(Size size);

    Optional<List<Shampoo>> findAllBySizeOrLabelIdOrderByPrice(Size size, Long label);

    Optional<List<Shampoo>> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Optional<List<Shampoo>> findByPriceLessThan(BigDecimal price);

    @Query("SELECT DISTINCT s.brand FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN ?1")
    Optional<List<String>> findAllByIngredientsIn(List<String> ingredients);

    @Query("SELECT s " +
            "FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "GROUP BY s.id " +
            "HAVING COUNT(i.id) < ?1")
    Optional<List<Shampoo>> findAllByIngredientsCountLessThan(int count);
}
