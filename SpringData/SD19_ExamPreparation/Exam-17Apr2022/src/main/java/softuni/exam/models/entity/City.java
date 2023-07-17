package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Column(name = "city_name", unique = true, nullable = false)
    @Size(min = 2, max = 60)
    private String cityName;

    @Column
    @Size(min = 2)
    private String description;

    @Column(nullable = false)
    @Min(value = 500)
    private int population;

    @OneToOne
    private Country country;

    public City() {
    }

    public City(String cityName, String description, int population, Country country) {
        this.cityName = cityName;
        this.description = description;
        this.population = population;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
