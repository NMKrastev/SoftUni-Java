package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.star.StarImportDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.STARS_FILE;

@Service
public class StarServiceImpl implements StarService {


    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;

    @Autowired
    public StarServiceImpl(Gson gson, ModelMapper mapper, ValidationUtils validationUtils,
                           StarRepository starRepository, ConstellationRepository constellationRepository) {
        this.validationUtils = validationUtils;
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(STARS_FILE);
    }

    @Override
    public String importStars() throws IOException {

        final List<StarImportDTO> starsImportDTO =
                Arrays.stream(this.gson.fromJson(this.readStarsFileContent(), StarImportDTO[].class))
                        .collect(Collectors.toList());

        for (StarImportDTO starDTO : starsImportDTO) {

            final Optional<Star> optionalStar = this.starRepository.findFirstByName(starDTO.getName());

            if (!this.validationUtils.isValid(starDTO) || optionalStar.isPresent()) {

                this.sb.append(String.format(INVALID_ENTITY, STAR))
                        .append(System.lineSeparator());

                continue;
            }

            final Constellation constellation =
                    this.constellationRepository.findById(starDTO.getConstellation())
                            .orElse(null);

            final Star star = this.mapper.map(starDTO, Star.class);

            star.setConstellation(constellation);

            this.starRepository.saveAndFlush(star);

            this.sb.append(String.format(STAR_IMPORT,
                            star.getName(), star.getLightYears()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }

    @Override
    public String exportStars() {

        final List<Star> stars = this.starRepository.findAllByStarTypeAndObserversIsNullOrderByLightYears(STAR_TYPE);

        stars
                .forEach(star -> this.sb.append(String.format(PRINT_FORMAT,
                                star.getName(), star.getLightYears(),
                                star.getDescription(), star.getConstellation().getName()))
                        .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
