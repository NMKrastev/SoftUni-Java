package com.example.A2_CarDealer.entities.dto.sale;

import com.example.A2_CarDealer.entities.dto.car.CarSaleDiscountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDiscountDTO {

    private CarSaleDiscountDTO car;

    private String customerName;

    private Double discount;

    private BigDecimal price;

    private BigDecimal priceWithDiscount;
}
