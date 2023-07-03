package com.example.A1_ProductShop.entities.dto.user;

import com.example.A1_ProductShop.entities.dto.product.ProductBasicInfoDTO;
import com.example.A1_ProductShop.entities.dto.product.ProductDTO;
import com.example.A1_ProductShop.entities.dto.product.ProductsSoldWithCountDTO;
import com.example.A1_ProductShop.entities.dto.user.wrapper.UsersWithProductsWrapperDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserDTO {

    private String firstName;

    private String lastName;

    private int age;

    private Set<UserDTO> friends;

    private Set<ProductDTO> sellingProducts;

    private Set<ProductDTO> boughtProducts;

    @XmlAttribute(name = "seller")
    public String getFullName() {
        return this.firstName == null ? this.lastName : this.firstName + " " + this.lastName;
    }

    public UsersWithProductsWrapperDTO toUsersWithProductsWrapperDTO() {

        return new UsersWithProductsWrapperDTO();
    }

    public UserWithProductsDTO toUserWithProductsDTO() {

        return new UserWithProductsDTO(this.firstName, this.lastName, this.age, toProductsSoldWithCountDTO());
    }


    public ProductsSoldWithCountDTO toProductsSoldWithCountDTO() {

        return new ProductsSoldWithCountDTO(sellingProducts
                .stream()
                .map(this::toProductBasicInfoDTO)
                .toList());
    }

    public ProductBasicInfoDTO toProductBasicInfoDTO(ProductDTO productDTO) {

        return new ProductBasicInfoDTO(productDTO.getName(), productDTO.getPrice());
    }
}
