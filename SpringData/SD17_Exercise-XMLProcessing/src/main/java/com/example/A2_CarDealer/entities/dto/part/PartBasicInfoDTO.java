package com.example.A2_CarDealer.entities.dto.part;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartBasicInfoDTO {

    private String name;

    private BigDecimal price;
}
