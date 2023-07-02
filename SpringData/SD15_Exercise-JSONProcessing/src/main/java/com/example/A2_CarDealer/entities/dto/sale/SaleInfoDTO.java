package com.example.A2_CarDealer.entities.dto.sale;

import com.example.A2_CarDealer.entities.dto.car.CarBasicInfoDTO;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfoDTO {

    @SerializedName("Id")
    private Long id;

    @SerializedName("Discount")
    private Double discount;

    @SerializedName("Car")
    private CarBasicInfoDTO car;
}
