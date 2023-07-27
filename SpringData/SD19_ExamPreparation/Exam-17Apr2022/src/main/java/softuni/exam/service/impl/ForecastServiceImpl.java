package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.forecast.ForecastImportDTO;
import softuni.exam.models.dto.forecast.ForecastImportWrapperDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeekType;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.FORECASTS_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtils validationUtils;
    private final CityRepository cityRepository;
    private final ForecastRepository forecastRepository;

    public ForecastServiceImpl(ModelMapper mapper, XmlParser xmlParser, ValidationUtils validationUtils,
                               CityRepository cityRepository, ForecastRepository forecastRepository) {
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.cityRepository = cityRepository;
        this.forecastRepository = forecastRepository;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(FORECASTS_PATH);
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        final ForecastImportWrapperDTO forecastsImportWrapperDTO =
                this.xmlParser.fromFile(FORECASTS_PATH.toFile(), ForecastImportWrapperDTO.class);

        final List<ForecastImportDTO> forecastsImportDTO = forecastsImportWrapperDTO.getForecasts();

        for (ForecastImportDTO forecastDTO : forecastsImportDTO) {

            final Optional<Forecast> optionalForecast =
                    this.forecastRepository
                            .findFirstByDayOfWeekAndCityId(forecastDTO.getDayOfWeek(), forecastDTO.getCity());

            if (!this.validationUtils.isValid(forecastDTO) || optionalForecast.isPresent()) {

                this.sb.append(String.format(INVALID_ENTITY, FORECAST))
                        .append(System.lineSeparator());
                continue;
            }

            final Forecast forecast = this.mapper.map(forecastDTO, Forecast.class);

            final City city = this.cityRepository.findFirstById(forecastDTO.getCity());

            forecast.setCity(city);

            this.forecastRepository.saveAndFlush(forecast);

            this.sb.append(String.format(SUCCESSFUL_IMPORT, FORECAST,
                    forecast.getDayOfWeek(), forecast.getMaxTemperature()))
                    .append(System.lineSeparator());

        }

        return this.sb.toString().trim();
    }

    @Override
    public String exportForecasts() {

        final List<Forecast> forecasts =
                this.forecastRepository
                        .findAllByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(DAY_OF_WEEK, POPULATION);

        for (Forecast forecast : forecasts) {

            this.sb.append(String.format(PRINT_FORMAT,
                    forecast.getCity().getCityName(),
                    forecast.getMinTemperature(), forecast.getMaxTemperature(),
                    forecast.getSunrise(),
                    forecast.getSunset()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
