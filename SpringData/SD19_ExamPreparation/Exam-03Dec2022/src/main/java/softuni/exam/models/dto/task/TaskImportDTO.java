package softuni.exam.models.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.dto.car.CarIdDTO;
import softuni.exam.models.dto.mechanic.MechanicFirstNameDTO;
import softuni.exam.models.dto.part.PartIdDTO;
import softuni.exam.util.XmlLocalDateTimeAdapter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDTO {

    @XmlElement
    @XmlJavaTypeAdapter(XmlLocalDateTimeAdapter.class)
    @NotNull
    private LocalDateTime date;

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement
    @NotNull
    private CarIdDTO car;

    @XmlElement
    @NotNull
    private MechanicFirstNameDTO mechanic;

    @XmlElement
    @NotNull
    private PartIdDTO part;
}
