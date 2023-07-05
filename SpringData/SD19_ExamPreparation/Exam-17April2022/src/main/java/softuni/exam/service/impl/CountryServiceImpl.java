package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static softuni.exam.util.Constant.*;

@Service
public class CountryServiceImpl implements CountryService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(Gson gson, ModelMapper mapper, CountryRepository countryRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() != 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(COUNTRIES_JSON_FILE_PATH)));
    }

    @Override
    public String importCountries() throws IOException {

        final Type type = new TypeToken<List<CountryDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(COUNTRIES_JSON_FILE_PATH));

        final List<CountryDTO> countriesDTO = gson.fromJson(reader, type);

        for (CountryDTO countryDTO : countriesDTO) {

            final Optional<Country> byCountryName = this.countryRepository.findByCountryName(countryDTO.getCountryName());

            final Country country;

            if (byCountryName.isEmpty()) {

                try {
                    country = this.mapper.map(countryDTO, Country.class);
                    this.countryRepository.save(country);
                } catch (Exception e) {
                    this.sb.append(INVALID_COUNTRY).append(System.lineSeparator());
                    continue;
                }

            } else {
                this.sb.append(INVALID_COUNTRY).append(System.lineSeparator());
                continue;
            }

            this.sb.append(String.format(COUNTRY_IMPORTED_FORMAT, country.getCountryName(), country.getCurrency()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
