package com.example.A2_CarDealer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SaleDiscountType {

    A(0),
    B(0.05),
    C(0.10),
    D(0.15),
    E(0.20),
    F(0.30),
    G(0.40),
    H(0.50);

    private final double percentage;
}
