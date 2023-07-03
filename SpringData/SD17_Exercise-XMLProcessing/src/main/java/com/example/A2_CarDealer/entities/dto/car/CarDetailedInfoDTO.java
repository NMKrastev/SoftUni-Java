package com.example.A2_CarDealer.entities.dto.car;

import com.example.A2_CarDealer.entities.dto.part.PartBasicInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailedInfoDTO {

    private String make;

    private String model;

    private Long travelledDistance;

    private List<PartBasicInfoDTO> parts;
}
