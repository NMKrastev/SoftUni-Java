package com.example.A2_CarDealer.entities.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierNotImporterByPartCountDTO {

    private Long id;

    private String name;

    private Long partsCount;
}
