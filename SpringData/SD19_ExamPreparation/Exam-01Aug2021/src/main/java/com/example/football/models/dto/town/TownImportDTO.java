package com.example.football.models.dto.town;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TownImportDTO {

    private String name;

    private int population;

    private String travelGuide;
}
