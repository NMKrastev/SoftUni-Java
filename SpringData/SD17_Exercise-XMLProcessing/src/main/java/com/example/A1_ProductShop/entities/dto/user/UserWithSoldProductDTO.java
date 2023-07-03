package com.example.A1_ProductShop.entities.dto.user;

import com.example.A1_ProductShop.entities.dto.product.ProductSoldDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithSoldProductDTO {

    private String firstName;

    private String lastName;

    private List<ProductSoldDTO> sellingProducts;
}

