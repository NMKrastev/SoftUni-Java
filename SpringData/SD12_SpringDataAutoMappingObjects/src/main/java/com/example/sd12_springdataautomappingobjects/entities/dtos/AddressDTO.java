package com.example.sd12_springdataautomappingobjects.entities.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {

    private String country;

    private String city;
}
