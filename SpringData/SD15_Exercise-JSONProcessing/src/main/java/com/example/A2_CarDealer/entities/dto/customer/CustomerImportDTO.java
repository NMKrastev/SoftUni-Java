package com.example.A2_CarDealer.entities.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerImportDTO {

    private String name;

    private LocalDateTime birthDate;

    private Boolean isYoungDriver;
}
