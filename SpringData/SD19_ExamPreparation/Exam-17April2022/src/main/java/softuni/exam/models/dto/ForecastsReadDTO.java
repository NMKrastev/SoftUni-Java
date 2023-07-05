package softuni.exam.models.dto;

import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DaysOfWeekEnum;
import softuni.exam.util.TimeAdapter;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastsReadDTO {

    @XmlElement(name = "day_of_week")
    private DaysOfWeekEnum day;

    @XmlElement(name = "max_temperature")
    private double maxTemperature;

    @XmlElement(name = "min_temperature")
    private double minTemperature;

    @XmlElement
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private LocalTime sunrise;

    @XmlElement
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private LocalTime sunset;

    @XmlElement
    private Long city;

    public ForecastsReadDTO() {
    }

    public ForecastsReadDTO(DaysOfWeekEnum day, double maxTemperature, double minTemperature, LocalTime sunrise, LocalTime sunset, Long city) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }

    public DaysOfWeekEnum getDay() {
        return day;
    }

    public void setDay(DaysOfWeekEnum day) {
        this.day = day;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
