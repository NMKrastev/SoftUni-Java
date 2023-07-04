package com.example.A1_ProductShop.entities.dto.product;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldWithCountDTO {

    @XmlAttribute
    private int count;

    @XmlElement(name = "product")
    private List<ProductBasicInfoDTO> products;

    public ProductsSoldWithCountDTO(List<ProductBasicInfoDTO> products) {
        this.products = products;
        this.count = products.size();
    }
}
