package com.example.sd12_springdataautomappingobjects.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CreateEmployeeDTO {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private AddressDTO address;

}
