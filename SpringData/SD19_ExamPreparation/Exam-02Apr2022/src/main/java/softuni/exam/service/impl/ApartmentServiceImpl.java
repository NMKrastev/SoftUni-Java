package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.apartment.ApartmentImportDTO;
import softuni.exam.models.dto.apartment.ApartmentImportWrapperDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constant.Message.*;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;

    public ApartmentServiceImpl(ModelMapper mapper, ValidationUtils validationUtils, XmlParser xmlParser,
                                ApartmentRepository apartmentRepository, TownRepository townRepository) {
        this.validationUtils = validationUtils;
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        final ApartmentImportWrapperDTO apartmentsImportWrapperDTO =
                this.xmlParser.fromFile(Path.of(APARTMENTS_FILE).toFile(), ApartmentImportWrapperDTO.class);

        final List<ApartmentImportDTO> apartmentsImportDTO = apartmentsImportWrapperDTO.getApartments();

        for (ApartmentImportDTO apartmentDTO : apartmentsImportDTO) {

            final Optional<Apartment> optionalApartment =
                    this.apartmentRepository.findFirstByTownTownNameAndArea(apartmentDTO.getTown(), apartmentDTO.getArea());

            if (!this.validationUtils.isValid(apartmentDTO) || optionalApartment.isPresent()) {

                this.sb.append(String.format(INVALID_ENTITY, APARTMENT))
                        .append(System.lineSeparator());
                continue;
            }

            final Apartment apartment = this.mapper.map(apartmentDTO, Apartment.class);

            apartment.setTown(this.townRepository.findFirstByTownName(apartmentDTO.getTown()).get());

            this.apartmentRepository.saveAndFlush(apartment);

            this.sb.append(String.format(SUCCESSFUL_APARTMENT_IMPORT,
                            apartment.getApartmentType(), apartment.getArea()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
