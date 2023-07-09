package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.car.CarByPictureCountDTO;
import softuni.exam.models.dtos.car.CarImportDTO;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.CARS_FILE_PATH;

@Service
public class CarServiceImpl implements CarService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final Gson gson;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ModelMapper mapper, Gson gson, CarRepository carRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return new String(Files.readAllBytes(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {

        final Type type = new TypeToken<List<CarImportDTO>>() {
        }.getType();

        final JsonReader reader = new JsonReader(new FileReader(CARS_FILE_PATH.toFile()));

        final List<CarImportDTO> carsImportDTO = this.gson.fromJson(reader, type);

        carsImportDTO
                .stream()
                .map(carDTO -> this.mapper.map(carDTO, Car.class))
                .collect(Collectors.toList())
                .forEach(car -> {
                    try {

                        this.carRepository.saveAndFlush(car);

                        this.sb.append(String.format(SUCCESSFULLY_ADDED_CAR, car.getMake(), car.getModel()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {
                        this.sb.append(INVALID_CAR).append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {

        final List<CarByPictureCountDTO> cars = this.carRepository.findAllCarsOrderByPicturesCount();

        cars
                .forEach(car -> this.sb.append(String.format(DATA_EXPORT_FORMAT,
                                car.getMake(), car.getModel(), car.getKilometers(),
                                car.getRegisteredOn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                car.getNumberOfPictures()))
                        .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
