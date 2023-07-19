package com.example.football.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(unique = true)
    @Size(min = 2)
    private String name;

    @Column
    @Min(1)
    private int population;

    @Column(name = "travel_guide", columnDefinition = "TEXT")
    @Size(min = 10)
    private String travelGuide;
}
