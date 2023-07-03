package com.example.A1_ProductShop.entities.dto.product;

import com.example.A1_ProductShop.entities.dto.category.CategoryDTO;
import com.example.A1_ProductShop.entities.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private BigDecimal price;

    private UserDTO buyer;

    private UserDTO seller;

    private Set<CategoryDTO> categories;

    public ProductInRangeWithNoBuyerDTO toProductInRangeWithBuyerDTO() {
        return new ProductInRangeWithNoBuyerDTO(name, price, this.seller.getFullName());
    }
}
