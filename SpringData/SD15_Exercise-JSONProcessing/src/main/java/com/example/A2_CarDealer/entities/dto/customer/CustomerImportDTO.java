package com.example.A2_CarDealer.entities.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerImportDTO {

    private String name;

    private String birthDate;

    private Boolean isYoungDriver;
}
