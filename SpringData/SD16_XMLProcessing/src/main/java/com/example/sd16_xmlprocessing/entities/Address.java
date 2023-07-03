package com.example.sd16_xmlprocessing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Override
    public String toString() {

        return "Address{" +
                "id=" + super.getId() + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
