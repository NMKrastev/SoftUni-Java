package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalTime;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity {

    @Column(nullable = false)
    @Enumerated
    private DaysOfWeekEnum day;

    @Column(name = "max_temperature", nullable = false)
    @Min(value = -20)
    @Max(value = 60)
    private double maxTemperature;

    @Column(name = "min_temperature", nullable = false)
    @Min(value = -50)
    @Max(value = 40)
    private double minTemperature;

    @Column(nullable = false)
    private LocalTime sunrise;

    @Column(nullable = false)
    private LocalTime sunset;

    @OneToOne
    private City city;

    public Forecast() {
    }

    public Forecast(DaysOfWeekEnum days, double maxTemperature, double minTemperature, LocalTime sunrise, LocalTime sunset, City city) {
        this.day = days;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }

    public DaysOfWeekEnum getDay() {
        return day;
    }

    public void setDay(DaysOfWeekEnum days) {
        this.day = days;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
