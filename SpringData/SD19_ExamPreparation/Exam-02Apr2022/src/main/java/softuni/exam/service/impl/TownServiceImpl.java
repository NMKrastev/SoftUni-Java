package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.town.TownImportDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.constant.Message.*;

@Service
public class TownServiceImpl implements TownService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(Gson gson, ModelMapper mapper, ValidationUtils validationUtils,
                           TownRepository townRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE));
    }

    @Override
    public String importTowns() throws IOException {

        final List<TownImportDTO> townsImportDTO =
                Arrays.stream(this.gson.fromJson(this.readTownsFileContent(), TownImportDTO[].class))
                        .toList();

        for (TownImportDTO townDTO : townsImportDTO) {

            if (!validationUtils.isValid(townDTO)
                    || this.townRepository.findFirstByTownName(townDTO.getTownName()).isPresent()) {
                this.sb.append(String.format(INVALID_ENTITY, TOWN))
                        .append(System.lineSeparator());
                continue;
            }

            final Town town = this.mapper.map(townDTO, Town.class);

            this.townRepository.saveAndFlush(town);

            this.sb.append(String.format(SUCCESSFUL_TOWN_IMPORT, town.getTownName(), town.getPopulation()))
                    .append(System.lineSeparator());
        }

        /*townsImportDTO
                .stream()
                .filter(townDTO -> {

                    boolean isValid = this.validationUtils.isValid(townDTO);

                    if (!isValid || this.townRepository.findFirstByTownName(townDTO.getTownName()).isPresent()) {

                        this.sb.append(String.format(INVALID_ENTITY, TOWN))
                                .append(System.lineSeparator());

                    } else {

                        this.sb.append(String.format(SUCCESSFUL_TOWN_IMPORT,
                                        townDTO.getTownName(), townDTO.getPopulation()))
                                .append(System.lineSeparator());
                    }

                    return isValid;
                })
                .map(townDTO -> this.mapper.map(townDTO, Town.class))
                .forEach(this.townRepository::saveAndFlush);*/

        return this.sb.toString().trim();
    }
}
