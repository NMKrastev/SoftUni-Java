package com.example.football.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    @Column(unique = true)
    @Size(min = 3)
    private String name;

    @Column(name = "stadium_name")
    @Size(min = 3)
    private String stadiumName;

    @Column(name = "fan_base")
    @Min(1000)
    private int fanBase;

    @Column(columnDefinition = "TEXT")
    @Size(min = 10)
    private String history;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Town town;
}
