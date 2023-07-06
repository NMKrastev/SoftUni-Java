package com.example.sd18_workshopmvcproject.entities.company;

import com.example.sd18_workshopmvcproject.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2)
    private String name;
}
