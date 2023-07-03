package com.example.sd16_xmlprocessing.entities.dtos;

import jakarta.xml.bind.annotation.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "addressXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDTO {

    @XmlElement
    private String country;

    @XmlElement(name = "city")
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "countries=" + country +
                ", city='" + city + '\'' +
                '}';
    }
}
