package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.mechanic.MechanicImportDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;

@Service
public class MechanicsServiceImpl implements MechanicsService {

    private static final String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final MechanicsRepository mechanicsRepository;

    @Autowired
    public MechanicsServiceImpl(Gson gson, ModelMapper mapper,
                                ValidationUtils validationUtils, MechanicsRepository mechanicsRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.mechanicsRepository = mechanicsRepository;
    }

    @Override
    public boolean areImported() {
        return this.mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {

        final List<MechanicImportDTO> mechanicsImportDTO =
                Arrays.stream(this.gson.fromJson(this.readMechanicsFromFile(), MechanicImportDTO[].class))
                        .collect(Collectors.toList());

        mechanicsImportDTO
                .forEach(mechanicDTO -> {

                    if (this.mechanicsRepository.findFirstByEmail(mechanicDTO.getEmail()).isPresent() ||
                            this.mechanicsRepository.findFirstByPhone(mechanicDTO.getPhone()).isPresent() ||
                            !this.validationUtils.isValid(mechanicDTO)) {

                        this.sb.append(String.format(INVALID_ENTITY, MECHANIC))
                                .append(System.lineSeparator());
                    } else {

                        final Mechanic mechanic = this.mapper.map(mechanicDTO, Mechanic.class);

                        this.mechanicsRepository.saveAndFlush(mechanic);

                        this.sb.append(String.format(SUCCESSFUL_MECHANIC_IMPORT, MECHANIC, mechanic.getFullName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
