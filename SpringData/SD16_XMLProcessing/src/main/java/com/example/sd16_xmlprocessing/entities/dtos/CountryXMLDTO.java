package com.example.sd16_xmlprocessing.entities.dtos;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryXMLDTO {

    @XmlAttribute
    //@XmlElement
    private String name;
}
