package com.example.sd18_workshopmvcproject.entities.project;

import com.example.sd18_workshopmvcproject.entities.BaseEntity;
import com.example.sd18_workshopmvcproject.entities.company.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "is_finished")
    private Boolean isFinished;

    @Column(nullable = false)
    private BigDecimal payment;

    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Company company;
}
