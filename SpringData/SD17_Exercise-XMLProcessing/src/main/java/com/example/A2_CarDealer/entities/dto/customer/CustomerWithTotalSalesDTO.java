package com.example.A2_CarDealer.entities.dto.customer;

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

    private String name;

    private Long boughtCars;

    private BigDecimal totalMoneySpent;
}
