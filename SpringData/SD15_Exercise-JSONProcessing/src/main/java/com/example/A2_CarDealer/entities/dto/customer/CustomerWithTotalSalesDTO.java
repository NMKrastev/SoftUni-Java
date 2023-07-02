package com.example.A2_CarDealer.entities.dto.customer;

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
public class CustomerWithTotalSalesDTO {

    @SerializedName("fullName ")
    private String name;

    @SerializedName("boughtCars")
    private Long boughtCars;

    @SerializedName("moneySpent")
    private BigDecimal totalMoneySpent;
}
