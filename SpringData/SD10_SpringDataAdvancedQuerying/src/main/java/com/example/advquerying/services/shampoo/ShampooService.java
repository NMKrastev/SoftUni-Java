package com.example.advquerying.services.shampoo;

import com.example.advquerying.entities.Shampoo;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {


    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, String size);

    List<Shampoo> findBySizeOrderById(String size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(String size, Long label);

    List<Shampoo> findByPriceGreaterThan(BigDecimal price);
}
