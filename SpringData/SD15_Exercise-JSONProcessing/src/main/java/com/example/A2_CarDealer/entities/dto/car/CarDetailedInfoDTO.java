package com.example.A2_CarDealer.entities.dto.car;

import com.example.A2_CarDealer.entities.dto.part.PartBasicInfoDTO;
import com.google.gson.annotations.SerializedName;
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

    @SerializedName("Make")
    private String make;

    @SerializedName("Model")
    private String model;

    @SerializedName("TraveledDistance")
    private Long travelledDistance;

    @SerializedName("parts")
    private List<PartBasicInfoDTO> parts;
}
