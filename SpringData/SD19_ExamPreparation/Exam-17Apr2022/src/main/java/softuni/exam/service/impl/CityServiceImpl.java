package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static softuni.exam.util.Constant.*;

@Service
public class CityServiceImpl implements CityService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CityServiceImpl(Gson gson, ModelMapper mapper, CityRepository cityRepository, CountryRepository countryRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() != 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {

        return new String(Files.readAllBytes(Paths.get(CITIES_JSON_FILE_PATH)));
    }

    @Override
    public String importCities() throws IOException {

        final Type type = new TypeToken<List<CityDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(CITIES_JSON_FILE_PATH));

        final List<CityDTO> citiesDTO = this.gson.fromJson(reader, type);

        for (CityDTO cityDTO : citiesDTO) {

            final City city;

            final Optional<City> cityByName = this.cityRepository.findByCityName(cityDTO.getCityName());

            if (cityByName.isEmpty()) {
                try {
                    //Could be CountryDTO
                    final Country country = this.countryRepository.findById(cityDTO.getCountry()).get();
                    city = this.mapper.map(cityDTO, City.class);
                    city.setCountry(country);
                     this.cityRepository.save(city);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    this.sb.append(INVALID_CITY).append(System.lineSeparator());
                    continue;
                }
            } else {
                this.sb.append(INVALID_CITY).append(System.lineSeparator());
                continue;
            }

            this.sb.append(String.format(CITY_IMPORTED_FORMAT, city.getCityName(), city.getPopulation()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
