package com.example.football.models.dto.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamImportDTO {

    private String name;

    private String stadiumName;

    private int fanBase;

    private String history;

    private String townName;
}
