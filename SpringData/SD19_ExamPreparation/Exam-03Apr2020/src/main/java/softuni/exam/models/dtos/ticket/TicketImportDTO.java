package softuni.exam.models.dtos.ticket;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.dtos.passenger.PassengerEmailDTO;
import softuni.exam.models.dtos.plane.PlaneNumberDTO;
import softuni.exam.models.dtos.town.TownBasicInfoDTO;
import softuni.exam.util.LocalDateTimeAdapter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDTO {

    @XmlElement(name = "serial-number")
    private String serialNumber;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "take-off")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime takeOff;

    @XmlElement(name = "from-town")
    private TownBasicInfoDTO fromTown;

    @XmlElement(name = "to-town")
    private TownBasicInfoDTO toTown;

    @XmlElement
    private PassengerEmailDTO passenger;

    @XmlElement
    private PlaneNumberDTO plane;
}
