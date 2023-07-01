package com.example.A1_ProductShop.entities.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductsSoldWithCountDTO {

    private int count;

    private List<ProductBasicInfoDTO> products;

    public ProductsSoldWithCountDTO(List<ProductBasicInfoDTO> products) {
        this.products = products;
        this.count = products.size();
    }
}
