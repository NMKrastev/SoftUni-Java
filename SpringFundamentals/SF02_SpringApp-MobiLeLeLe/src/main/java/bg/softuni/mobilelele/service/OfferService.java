package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.BrandDTO;
import bg.softuni.mobilelele.model.entity.OfferEntity;

import java.util.List;

public interface OfferService {
    List<OfferEntity> findAllOffers();

    OfferEntity findOfferById(Long id);

    void addOffer(AddOfferDTO addOfferDTO);

}
