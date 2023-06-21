package com.example.advquerying.services.shampoo;

import com.example.advquerying.entities.Shampoo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {


    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, String size);

    List<Shampoo> findBySizeOrderById(String size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(String size, Long label);

    List<Shampoo> findByPriceGreaterThan(BigDecimal price);

    Integer countShampoosByPriceLessThan(BigDecimal price);

    List<String> findAllByIngredientsIn(List<String> ingredients);

    List<Shampoo> findAllByIngredientsCountLessThan(int count);
}
