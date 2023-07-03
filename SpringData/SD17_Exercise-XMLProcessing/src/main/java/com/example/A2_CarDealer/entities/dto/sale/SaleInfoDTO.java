package com.example.A2_CarDealer.entities.dto.sale;

import com.example.A2_CarDealer.entities.dto.car.CarBasicInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfoDTO {

    private Long id;

    private Double discount;

    private CarBasicInfoDTO car;
}
