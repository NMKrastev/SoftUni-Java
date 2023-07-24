package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.offer.OfferImportDTO;
import softuni.exam.models.dto.offer.OfferImportWrapperDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
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
public class OfferServiceImpl implements OfferService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    public OfferServiceImpl(ModelMapper mapper, ValidationUtils validationUtils, XmlParser xmlParser,
                            OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        final OfferImportWrapperDTO offersImportWrapperDTO =
                this.xmlParser.fromFile(Path.of(OFFERS_FILE).toFile(), OfferImportWrapperDTO.class);

        final List<OfferImportDTO> offersImportDTO = offersImportWrapperDTO.getOffers();

        for (OfferImportDTO offerDTO : offersImportDTO) {

            final Optional<Agent> optionalAgent =
                    this.agentRepository.findFirstByFirstName(offerDTO.getAgent().getName());

            if (!this.validationUtils.isValid(offerDTO)
                    || optionalAgent.isEmpty()) {

                this.sb.append(String.format(INVALID_ENTITY, OFFER))
                        .append(System.lineSeparator());
                continue;
            }

            final Apartment apartment = this.apartmentRepository.findById(offerDTO.getApartment().getId()).get();

            final Offer offer = this.mapper.map(offerDTO, Offer.class);

            offer.setAgent(optionalAgent.get());
            offer.setApartment(apartment);

            this.offerRepository.saveAndFlush(offer);

            this.sb.append(String.format(SUCCESSFUL_OFFER_IMPORT, offer.getPrice().setScale(2)))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }

    @Override
    public String exportOffers() {

        final List<Offer> offers =
                this.offerRepository.findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms);

        offers
                .forEach(o -> this.sb.append(
                        String.format(PRINT_FORMAT,
                                o.getAgent().getFullName(), o.getId(),
                                o.getApartment().getArea(),
                                o.getApartment().getTown().getTownName(),
                                o.getPrice().setScale(2)))
                        .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
