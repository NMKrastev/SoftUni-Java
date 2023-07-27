package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity {

    @Column(name = "day_of_week", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DayOfWeekType dayOfWeek;

    @Column(name = "max_temperature", nullable = false)
    private double maxTemperature;

    @Column(name = "min_temperature", nullable = false)
    private double minTemperature;

    @Column(nullable = false)
    private LocalTime sunrise;

    @Column(nullable = false)
    private LocalTime sunset;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private City city;


}
