package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.car.CarImportDTO;
import softuni.exam.models.dto.car.CarImportWrapperDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.constant.Message.*;

@Service
public class CarsServiceImpl implements CarsService {

    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final XMLParser xmlParser;
    private final CarsRepository carsRepository;

    @Autowired
    public CarsServiceImpl(ModelMapper mapper, ValidationUtils validationUtils,
                           XMLParser xmlParser, CarsRepository carsRepository) {
        this.sb = new StringBuilder();
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.carsRepository = carsRepository;
    }

    @Override
    public boolean areImported() {
        return this.carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {

        final CarImportWrapperDTO carsImportWrapperDTO =
                xmlParser.fromFile(Path.of(CARS_FILE_PATH).toFile(), CarImportWrapperDTO.class);

        final List<CarImportDTO> carsImportDTO = carsImportWrapperDTO.getCars();

        carsImportDTO
                .forEach(carDTO -> {

                    if (this.carsRepository.findFirstByPlateNumber(carDTO.getPlateNumber()).isPresent() ||
                            !this.validationUtils.isValid(carDTO)) {

                        this.sb.append(String.format(INVALID_ENTITY, CAR))
                                .append(System.lineSeparator());
                    } else {

                        final Car car = this.mapper.map(carDTO, Car.class);

                        this.carsRepository.saveAndFlush(car);

                        this.sb.append(String.format(SUCCESSFUL_CAR_IMPORT, CAR,
                                        car.getCarMake(), car.getCarModel()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
