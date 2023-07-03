package com.example.A2_CarDealer.entities.dto.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarBasicInfoDTO {

    private String make;

    private String model;

    private Long travelledDistance;
}
