package softuni.exam.models.dto;

public class CityDTO {

    private String cityName;

    private String description;

    private int population;

    private Long country;

    public CityDTO() {
    }

    public CityDTO(String cityName, String description, int population, Long countryId) {
        this.cityName = cityName;
        this.description = description;
        this.population = population;
        this.country = countryId;
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

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long countryId) {
        this.country = countryId;
    }
}
