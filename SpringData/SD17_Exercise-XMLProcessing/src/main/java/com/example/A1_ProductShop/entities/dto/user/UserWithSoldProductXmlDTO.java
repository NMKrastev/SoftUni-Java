package com.example.A1_ProductShop.entities.dto.user;

import com.example.A1_ProductShop.entities.dto.product.ProductSoldDTO;
import com.example.A1_ProductShop.entities.dto.product.wrapper.ProductsSoldWrapperDTO;
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
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductXmlDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    private ProductsSoldWrapperDTO sellingProducts;
}
