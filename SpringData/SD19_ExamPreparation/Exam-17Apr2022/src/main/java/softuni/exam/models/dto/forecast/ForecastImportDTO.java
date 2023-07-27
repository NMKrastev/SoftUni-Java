package softuni.exam.models.dto.forecast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.DayOfWeekType;
import softuni.exam.util.XmlLocalTimeAdapter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDTO {

    @XmlElement(name = "day_of_week")
    @NotNull
    private DayOfWeekType dayOfWeek;

    @XmlElement(name = "max_temperature")
    @DecimalMin(value = "-20.00")
    @DecimalMax(value = "60.00")
    private double maxTemperature;

    @XmlElement(name = "min_temperature")
    @DecimalMin(value = "-50.00")
    @DecimalMax(value = "40.00")
    private double minTemperature;

    @XmlElement
    @XmlJavaTypeAdapter(XmlLocalTimeAdapter.class)
    @NotNull
    private LocalTime sunrise;

    @XmlElement
    @XmlJavaTypeAdapter(XmlLocalTimeAdapter.class)
    @NotNull
    private LocalTime sunset;

    @XmlElement
    @NotNull
    @Positive
    private Long city;
}
