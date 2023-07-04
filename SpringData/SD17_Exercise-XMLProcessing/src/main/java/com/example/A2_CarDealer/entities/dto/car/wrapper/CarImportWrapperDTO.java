package com.example.A2_CarDealer.entities.dto.car.wrapper;

import com.example.A2_CarDealer.entities.dto.car.CarImportDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportWrapperDTO {

    @XmlElement(name = "car")
    private List<CarImportDTO> cars;
}
