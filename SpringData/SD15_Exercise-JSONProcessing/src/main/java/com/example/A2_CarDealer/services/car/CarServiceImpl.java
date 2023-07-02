package com.example.A2_CarDealer.services.car;

import com.example.A2_CarDealer.entities.dto.car.CarDetailedInfoDTO;
import com.example.A2_CarDealer.entities.dto.car.CarToyotaDTO;
import com.example.A2_CarDealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A2_CarDealer.constants.Messages.*;
import static com.example.A2_CarDealer.constants.Paths.ALL_TOYOTA_CARS_FILE_PATH;
import static com.example.A2_CarDealer.constants.Paths.CARS_AND_PARTS_FILE_PATH;
import static com.example.A2_CarDealer.utils.Utils.writeJsonIntoFile;

@Service
public class CarServiceImpl implements CarService {

    private final ModelMapper mapper;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ModelMapper mapper, CarRepository carRepository) {
        this.mapper = mapper;
        this.carRepository = carRepository;
    }

    @Override
    public String findAllCarsFromMakeToyota() throws IOException {

        final List<CarToyotaDTO> carsToyotaDTO =
                this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(TOYOTA)
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(car -> this.mapper.map(car, CarToyotaDTO.class))
                        .toList();

        writeJsonIntoFile(carsToyotaDTO, ALL_TOYOTA_CARS_FILE_PATH);

        return ALL_TOYOTA_CARS_SAVED_SUCCESSFULLY;
    }

    @Override
    public String findAllCarsAndTheirParts() throws IOException {

        final List<CarDetailedInfoDTO> carDetailedInfoDTOS =
                this.carRepository.findAll()
                        .stream()
                        .map(car -> this.mapper.map(car, CarDetailedInfoDTO.class))
                        .toList();

        writeJsonIntoFile(carDetailedInfoDTOS, CARS_AND_PARTS_FILE_PATH);

        return CARS_AND_PARTS_SAVED_SUCCESSFULLY;
    }
}
