package com.example.A2_CarDealer.entities.dto.car;

import com.example.A2_CarDealer.entities.dto.part.wrapper.PartBasicInfoWrapperDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDetailedInfoDTO {

    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @XmlElement(name = "parts")
    private PartBasicInfoWrapperDTO parts;
}
