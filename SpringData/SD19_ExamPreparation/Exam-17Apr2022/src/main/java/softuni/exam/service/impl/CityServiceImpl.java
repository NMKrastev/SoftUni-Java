package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.city.CityImportDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.CITIES_PATH;

@Service
public class CityServiceImpl implements CityService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(Gson gson, ModelMapper mapper, ValidationUtils validationUtils,
                           CountryRepository countryRepository, CityRepository cityRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(CITIES_PATH);
    }

    @Override
    public String importCities() throws IOException {

        final List<CityImportDTO> citiesImportDTO =
                Arrays.stream(this.gson.fromJson(this.readCitiesFileContent(), CityImportDTO[].class))
                        .toList();

        for (CityImportDTO cityDTO : citiesImportDTO) {

            final Optional<City> optionalCity = this.cityRepository.findFirstByCityName(cityDTO.getCityName());
            final Optional<Country> optionalCountry = this.countryRepository.findById(cityDTO.getCountry());

            if (!this.validationUtils.isValid(cityDTO) || optionalCity.isPresent()
                    || optionalCountry.isEmpty()) {

                this.sb.append(String.format(INVALID_ENTITY, CITY))
                        .append(System.lineSeparator());
                continue;
            }

            final City city = this.mapper.map(cityDTO, City.class);


            city.setCountry(optionalCountry.get());

            this.cityRepository.saveAndFlush(city);

            this.sb.append(String.format(SUCCESSFUL_IMPORT, CITY,
                            city.getCityName(), city.getPopulation()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
