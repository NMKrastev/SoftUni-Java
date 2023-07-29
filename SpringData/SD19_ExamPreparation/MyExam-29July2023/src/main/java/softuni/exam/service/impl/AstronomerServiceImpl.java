package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.astronomer.AstronomerImportDTO;
import softuni.exam.models.dto.astronomer.AstronomerImportWrapperDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.ASTRONOMERS_FILE;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtils validationUtils;
    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;

    @Autowired
    public AstronomerServiceImpl(ModelMapper mapper, XmlParser xmlParser, ValidationUtils validationUtils,
                                 AstronomerRepository astronomerRepository, StarRepository starRepository) {
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(ASTRONOMERS_FILE);
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        final AstronomerImportWrapperDTO astronomersImportWrapperDTO =
                this.xmlParser.fromFile(ASTRONOMERS_FILE.toFile(), AstronomerImportWrapperDTO.class);

        final List<AstronomerImportDTO> astronomersImportDTO = astronomersImportWrapperDTO.getAstronomers();

        for (AstronomerImportDTO astronomerDTO : astronomersImportDTO) {

            final Optional<Astronomer> optionalAstronomer =
                    this.astronomerRepository
                            .findFirstByFirstNameAndLastName(astronomerDTO.getFirstName(), astronomerDTO.getLastName());

            final Optional<Star> optionalStar = this.starRepository.findById(astronomerDTO.getObservingStar());

            if (!this.validationUtils.isValid(astronomerDTO) || optionalAstronomer.isPresent()
                    || optionalStar.isEmpty()) {

                this.sb.append(String.format(INVALID_ENTITY, ASTRONOMER))
                        .append(System.lineSeparator());

                continue;
            }

            final Astronomer astronomer = this.mapper.map(astronomerDTO, Astronomer.class);

            astronomer.setObservingStar(optionalStar.get());

            this.astronomerRepository.saveAndFlush(astronomer);

            this.sb.append(String.format(ASTRONOMER_IMPORT,
                            astronomer.getFullName(), astronomer.getAverageObservationHours()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
