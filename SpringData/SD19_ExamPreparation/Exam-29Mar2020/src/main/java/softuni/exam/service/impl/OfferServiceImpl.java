package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.offer.OfferImportDTO;
import softuni.exam.models.dtos.offer.OfferImportWrapperDTO;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static softuni.exam.constant.Message.INVALID_OFFER;
import static softuni.exam.constant.Message.SUCCESSFULLY_ADDED_OFFER;
import static softuni.exam.constant.Paths.OFFERS_FILE_PATH;

@Service
public class OfferServiceImpl implements OfferService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final OfferRepository offerRepository;
    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;

    public OfferServiceImpl(ModelMapper mapper, OfferRepository offerRepository,
                            CarRepository carRepository, SellerRepository sellerRepository) {
        this.mapper = mapper;
        this.offerRepository = offerRepository;
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return new String(Files.readAllBytes(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        final FileReader reader = new FileReader(OFFERS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(OfferImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final OfferImportWrapperDTO offersImportWrapperDTO = (OfferImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<OfferImportDTO> offersDTO = offersImportWrapperDTO.getOffers();

        for (OfferImportDTO offerDTO : offersDTO) {

            final Offer offer = this.mapper.map(offerDTO, Offer.class);

            final Car car = this.carRepository.findById(offer.getCar().getId()).get();

            final Seller seller = this.sellerRepository.findById(offer.getSeller().getId()).get();

            offer.setCar(car);
            offer.setPictures(car.getPictures());
            offer.setSeller(seller);

            try {

                this.offerRepository.saveAndFlush(offer);

                this.sb.append(String.format(SUCCESSFULLY_ADDED_OFFER, offer.getAddedOn(), offer.isHasGoldStatus()))
                        .append(System.lineSeparator());

            } catch (Exception e) {

                this.sb.append(INVALID_OFFER).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}
