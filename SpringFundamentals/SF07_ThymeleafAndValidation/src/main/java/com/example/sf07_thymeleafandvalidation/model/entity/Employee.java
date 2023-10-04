package com.example.sf07_thymeleafandvalidation.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "educational_level", nullable = false)
    private String educationLevel;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Company company;
}
