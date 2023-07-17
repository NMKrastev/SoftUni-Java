package softuni.exam.models.entity;

import org.modelmapper.spi.SourceGetter;
import softuni.exam.models.dto.CityDTO;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity implements SourceGetter<CityDTO> {

    @Column(name = "country_name", unique = true, nullable = false)
    @Size(min = 2, max = 60)
    private String countryName;

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String currency;

    public Country() {
    }

    public Country(String countryName, String currency) {
        this.countryName = countryName;
        this.currency = currency;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public Object get(CityDTO source) {
        return null;
    }
}
