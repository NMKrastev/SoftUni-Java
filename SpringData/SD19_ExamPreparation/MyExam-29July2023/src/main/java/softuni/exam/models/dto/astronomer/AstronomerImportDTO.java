package softuni.exam.models.dto.astronomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.util.LocalDateAdapter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportDTO {

    @XmlElement(name = "average_observation_hours")
    @NotNull
    @DecimalMin(value = "500.00")
    private double averageObservationHours;

    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthday;

    @XmlElement(name = "first_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @XmlElement
    @NotNull
    @DecimalMin(value = "15000.00")
    private double salary;

    @XmlElement(name = "observing_star_id")
    @NotNull
    private Long observingStar;
}
