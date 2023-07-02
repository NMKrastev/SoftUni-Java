package com.example.A2_CarDealer.entities.dto.sale;

import com.example.A2_CarDealer.entities.dto.car.CarSaleDiscountDTO;
import com.google.gson.annotations.SerializedName;
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

    @SerializedName("car")
    private CarSaleDiscountDTO car;

    @SerializedName("customerName")
    private String customerName;

    @SerializedName("Discount")
    private Double discount;

    @SerializedName("price")
    private BigDecimal price;

    @SerializedName("priceWithDiscount")
    private BigDecimal priceWithDiscount;
}
