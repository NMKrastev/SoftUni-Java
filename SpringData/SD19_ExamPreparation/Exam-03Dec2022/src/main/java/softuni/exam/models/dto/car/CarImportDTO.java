package softuni.exam.models.dto.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDTO {

    @XmlElement
    @NotNull
    @Size(min = 2, max = 30)
    private String carMake;

    @XmlElement
    @NotNull
    @Size(min = 2, max = 30)
    private String carModel;

    @XmlElement
    @NotNull
    @Positive
    private Integer year;

    @XmlElement
    @NotNull
    @Size(min = 2, max = 30)
    private String plateNumber;

    @XmlElement
    @NotNull
    @Positive
    private Integer kilometers;

    @XmlElement
    @NotNull
    @DecimalMin(value = "1.00")
    private Double engine;

    @XmlElement
    @NotNull
    private String carType;
}
