package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.OfferEntity;

import java.util.List;

public interface OfferService {
    List<OfferEntity> findAllOffers();
}
