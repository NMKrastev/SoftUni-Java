package com.example.A1_ProductShop.entities.dto.user.wrapper;

import com.example.A1_ProductShop.entities.dto.user.UserWithProductsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsersWithProductsWrapperDTO {

    private long usersCount;

    private List<UserWithProductsDTO> users;

    public UsersWithProductsWrapperDTO(List<UserWithProductsDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
