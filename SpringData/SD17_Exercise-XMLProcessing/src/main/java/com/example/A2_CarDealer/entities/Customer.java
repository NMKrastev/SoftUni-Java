package com.example.A2_CarDealer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "is_young_driver", columnDefinition = "BOOLEAN")
    private Boolean isYoungDriver;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Sale> sales;
}
