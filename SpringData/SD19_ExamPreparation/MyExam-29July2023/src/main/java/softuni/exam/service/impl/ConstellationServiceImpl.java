package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.constellation.ConstellationImportDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.CONSTELLATIONS_FILE;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final ConstellationRepository constellationRepository;

    @Autowired
    public ConstellationServiceImpl(Gson gson, ModelMapper mapper,
                                    ValidationUtils validationUtils, ConstellationRepository constellationRepository) {
        this.sb = new StringBuilder();
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.mapper = mapper;
        this.constellationRepository = constellationRepository;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(CONSTELLATIONS_FILE);
    }

    @Override
    public String importConstellations() throws IOException {

        final List<ConstellationImportDTO> constellationsImportDTO =
                Arrays.stream(this.gson.fromJson(this.readConstellationsFromFile(), ConstellationImportDTO[].class))
                        .collect(Collectors.toList());

        for (ConstellationImportDTO constellationDTO : constellationsImportDTO) {

            final Optional<Constellation> optionalConstellation =
                    this.constellationRepository.findFirstByName(constellationDTO.getName());

            if (!this.validationUtils.isValid(constellationDTO) || optionalConstellation.isPresent()) {

                this.sb.append(String.format(INVALID_ENTITY, CONSTELLATION))
                        .append(System.lineSeparator());
                continue;
            }

            final Constellation constellation = this.mapper.map(constellationDTO, Constellation.class);

            this.constellationRepository.saveAndFlush(constellation);

            this.sb.append(String.format(CONSTELLATION_IMPORT,
                            constellation.getName(), constellation.getDescription()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
