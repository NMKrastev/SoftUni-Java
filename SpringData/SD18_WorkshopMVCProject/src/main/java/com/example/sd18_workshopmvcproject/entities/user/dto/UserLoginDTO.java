package com.example.sd18_workshopmvcproject.entities.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginDTO {

    private String username;

    private String password;
}
