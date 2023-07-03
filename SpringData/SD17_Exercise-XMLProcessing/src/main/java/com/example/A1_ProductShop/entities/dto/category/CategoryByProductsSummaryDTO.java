package com.example.A1_ProductShop.entities.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryByProductsSummaryDTO {

    private String name;

    private long productsCount;

    private double averagePrice;

    private BigDecimal totalRevenue;
}
