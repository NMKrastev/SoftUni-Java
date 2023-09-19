package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {

        this.offerRepository = offerRepository;
    }

    @Override
    public List<OfferEntity> findAllOffers() {

        return this.offerRepository.findAll();
    }
}
