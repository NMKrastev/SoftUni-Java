package com.example.A2_CarDealer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SaleDiscountType {

    A(0),
    B(5),
    C(10),
    D(15),
    E(20),
    F(30),
    G(40),
    H(50);

    private final double percentage;

}
