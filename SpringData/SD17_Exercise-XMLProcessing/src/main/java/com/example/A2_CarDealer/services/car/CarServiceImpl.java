package com.example.A2_CarDealer.services.car;

import com.example.A2_CarDealer.entities.dto.car.CarDetailedInfoDTO;
import com.example.A2_CarDealer.entities.dto.car.CarToyotaDTO;
import com.example.A2_CarDealer.entities.dto.car.wrapper.CarDetailedInfoWrapperDTO;
import com.example.A2_CarDealer.entities.dto.car.wrapper.CarToyotaWrapperDTO;
import com.example.A2_CarDealer.repositories.CarRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A2_CarDealer.constants.Messages.*;
import static com.example.A2_CarDealer.constants.Paths.ALL_TOYOTA_CARS_FILE_PATH;
import static com.example.A2_CarDealer.constants.Paths.CARS_AND_PARTS_FILE_PATH;

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
    public String findAllCarsFromMakeToyota() throws JAXBException {

        final List<CarToyotaDTO> carsToyotaDTO =
                this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(TOYOTA)
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(car -> this.mapper.map(car, CarToyotaDTO.class))
                        .toList();

        final CarToyotaWrapperDTO usersWithSoldProductWrapperDTO =
                new CarToyotaWrapperDTO(carsToyotaDTO);

        final JAXBContext context = JAXBContext.newInstance(CarToyotaWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(usersWithSoldProductWrapperDTO, ALL_TOYOTA_CARS_FILE_PATH.toFile());

        return ALL_TOYOTA_CARS_SAVED_SUCCESSFULLY;
    }

    @Override
    public String findAllCarsAndTheirParts() throws JAXBException {

        final List<CarDetailedInfoDTO> carDetailedInfoDTOS =
                this.carRepository.findAll()
                        .stream()
                        .map(car -> this.mapper.map(car, CarDetailedInfoDTO.class))
                        .toList();

        final CarDetailedInfoWrapperDTO carDetailedInfoWrapperDTO =
                new CarDetailedInfoWrapperDTO(carDetailedInfoDTOS);

        final JAXBContext context = JAXBContext.newInstance(CarDetailedInfoWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(carDetailedInfoWrapperDTO, CARS_AND_PARTS_FILE_PATH.toFile());

        return CARS_AND_PARTS_SAVED_SUCCESSFULLY;
    }
}
