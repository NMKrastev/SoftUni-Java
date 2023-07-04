package com.example.A1_ProductShop.entities.dto.user.wrapper;

import com.example.A1_ProductShop.entities.dto.user.UserWithProductsDTO;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithProductsWrapperDTO {

    @XmlAttribute(name = "count")
    private long usersCount;

    @XmlElement(name = "user")
    private List<UserWithProductsDTO> users;

    public UsersWithProductsWrapperDTO(List<UserWithProductsDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
