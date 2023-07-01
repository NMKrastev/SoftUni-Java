package com.example.A1_ProductShop.entities.dto.user;

import com.example.A1_ProductShop.entities.dto.product.ProductsSoldWithCountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithProductsDTO {

    private String firstName;

    private String lastName;

    private int age;

    private ProductsSoldWithCountDTO products;
}
