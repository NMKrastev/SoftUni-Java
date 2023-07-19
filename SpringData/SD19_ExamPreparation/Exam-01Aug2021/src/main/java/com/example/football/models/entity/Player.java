package com.example.football.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "first_name")
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2)
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    @Enumerated
    private PositionType position;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Town town;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Stat stat;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
