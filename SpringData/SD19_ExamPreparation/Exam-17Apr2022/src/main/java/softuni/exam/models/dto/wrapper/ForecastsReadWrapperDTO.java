package softuni.exam.models.dto.wrapper;

import softuni.exam.models.dto.ForecastsReadDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastsReadWrapperDTO {

    @XmlElement(name = "forecast")
    private List<ForecastsReadDTO> forecasts;

    public ForecastsReadWrapperDTO() {
        this.forecasts = new ArrayList<>();
    }

    public ForecastsReadWrapperDTO(List<ForecastsReadDTO> forecasts) {
        this.forecasts = forecasts;
    }

    public List<ForecastsReadDTO> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastsReadDTO> forecasts) {
        this.forecasts = forecasts;
    }
}
