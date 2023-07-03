package com.example.A2_CarDealer.entities.dto.customer;

import com.example.A2_CarDealer.entities.dto.sale.SaleInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoOrderedDTO {

    private Long id;

    private String name;

    private String birthDate;

    private Boolean isYoungDriver;

    private List<SaleInfoDTO> sales;

}
