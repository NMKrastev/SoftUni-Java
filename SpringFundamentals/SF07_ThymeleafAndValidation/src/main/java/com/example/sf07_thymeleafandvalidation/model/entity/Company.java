package com.example.sf07_thymeleafandvalidation.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal budget;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String town;

    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Employee> employees;
}
