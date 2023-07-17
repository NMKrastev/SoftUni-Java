package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastsReadDTO;
import softuni.exam.models.dto.wrapper.ForecastsReadWrapperDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static softuni.exam.util.Constant.*;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ModelMapper mapper;
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;

    @Autowired
    public ForecastServiceImpl(ModelMapper mapper, ForecastRepository forecastRepository, CityRepository cityRepository) {
        this.mapper = mapper;

        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() != 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(FORECASTS_XML_FILE_PATH)));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        final FileReader reader = new FileReader(FORECASTS_XML_FILE_PATH);

        final JAXBContext context = JAXBContext.newInstance(ForecastsReadWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ForecastsReadWrapperDTO forecastsReadWrapperDTO = (ForecastsReadWrapperDTO) unmarshaller.unmarshal(reader);

        final List<ForecastsReadDTO> forecastsDTO = forecastsReadWrapperDTO.getForecasts();

        final StringBuilder sb = new StringBuilder();

        for (ForecastsReadDTO forecastDTO : forecastsDTO) {

            final Optional<Forecast> doesForecastExist =
                    this.forecastRepository.findByCityIdAndDay(forecastDTO.getCity(), forecastDTO.getDay());

            if (doesForecastExist.isPresent()) {
                sb.append(INVALID_FORECAST).append(System.lineSeparator());
                continue;
            }

            try {

                final Forecast forecast = this.mapper.map(forecastDTO, Forecast.class);

                final City city = this.cityRepository.findById(forecastDTO.getCity()).get();

                forecast.setCity(city);

                this.forecastRepository.saveAndFlush(forecast);

                sb.append(String.format(FORECAST_IMPORTED_FORMAT,
                                forecast.getDay(), forecast.getMaxTemperature()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                sb.append(INVALID_FORECAST).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {

        final StringBuilder sb = new StringBuilder();

        final List<Forecast> allForecastByCriteria =
                this.forecastRepository
                        .findAllByDayAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(DAY, POPULATION).get();

        allForecastByCriteria
                .forEach(e -> sb.append(String.format(EXPORT_FORECAST_PRINT_FORMAT,
                                e.getCity().getCityName(), e.getMinTemperature(),
                                e.getMaxTemperature(), e.getSunrise(), e.getSunset()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
