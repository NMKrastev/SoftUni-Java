package com.example.A2_UserSystem.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "bornInTown")
    private Set<User> bornInTownUser;

    @OneToMany(mappedBy = "currentlyLivingInTown")
    private Set<User> currentlyLivingInTownUser;
}
