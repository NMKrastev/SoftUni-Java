package softuni.exam.models.dtos.plane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportDTO {

    @XmlElement(name = "register-number")
    private String registerNumber;

    @XmlElement
    private int capacity;

    @XmlElement
    private String airline;
}
