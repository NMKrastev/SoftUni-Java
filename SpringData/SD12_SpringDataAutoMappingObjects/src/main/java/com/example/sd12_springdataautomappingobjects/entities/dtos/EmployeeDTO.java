package com.example.sd12_springdataautomappingobjects.entities.dtos;


import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private BigDecimal salary;

    //private String addressCity;
    //private String city;


    @Override
    public String toString() {
        return String.format("%s %s %.2f ", this.firstName, this.lastName, this.salary);
    }
}
