package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.passenger.PassengerByCountOfTicketDTO;
import softuni.exam.models.dtos.passenger.PassengerImportDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.FileUtil;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.PASSENGERS_FILE_PATH;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;

    @Autowired
    public PassengerServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil,
                                PassengerRepository passengerRepository, TownRepository townRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return this.fileUtil.readFile(PASSENGERS_FILE_PATH);
    }

    @Override
    public String importPassengers() throws IOException {

        final JsonReader reader = new JsonReader(new FileReader(PASSENGERS_FILE_PATH.toFile()));

        final Type type = new TypeToken<List<PassengerImportDTO>>(){}.getType();

        final List<PassengerImportDTO> passengersImportDTO = this.gson.fromJson(reader, type);

        passengersImportDTO
                .stream()
                .map(passengerDTO -> {

                    final Passenger passenger = this.mapper.map(passengerDTO, Passenger.class);

                    final Town town = this.townRepository.findByName(passengerDTO.getTown());

                    passenger.setTown(town);

                    return passenger;
                })
                .collect(Collectors.toList())
                .forEach(passenger -> {

                    try {

                        this.passengerRepository.saveAndFlush(passenger);

                        this.sb.append(String.format(SUCCESSFUL_IMPORT, passenger.getClass().getSimpleName(),
                                        passenger.getLastName(), passenger.getEmail()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_IMPORT, passenger.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        final List<PassengerByCountOfTicketDTO> passengers = this.passengerRepository.findPassengerByCountOfTicket();

        passengers
                .forEach(passenger ->
                        this.sb.append(String.format(PRINT_FORMAT, passenger.getFirstName(), passenger.getLastName(),
                                passenger.getEmail(), passenger.getPhoneNumber(), passenger.getCountOfTickets()))
                                .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
