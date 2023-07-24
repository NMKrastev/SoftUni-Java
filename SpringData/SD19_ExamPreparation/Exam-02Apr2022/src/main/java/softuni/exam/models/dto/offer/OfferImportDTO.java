package softuni.exam.models.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.dto.agent.AgentNameDTO;
import softuni.exam.models.dto.apartment.ApartmentIdDTO;
import softuni.exam.util.XmlLocalDateAdapter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDTO {

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement(name = "agent")
    @NotNull
    private AgentNameDTO agent;

    @XmlElement(name = "apartment")
    @NotNull
    private ApartmentIdDTO apartment;

    @XmlElement
    @XmlJavaTypeAdapter(XmlLocalDateAdapter.class)
    @NotNull
    private LocalDate publishedOn;
}
