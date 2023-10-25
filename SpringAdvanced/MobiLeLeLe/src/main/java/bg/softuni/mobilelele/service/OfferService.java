package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.dto.OfferUpdateDTO;

import java.util.List;

public interface OfferService {

    List<OfferDetailsDTO> findAllOffers();

    OfferDetailsDTO findOfferById(Long id);

    void addOffer(AddOfferDTO addOfferDTO);

    OfferUpdateDTO findOfferToUpdate(Long id);

    boolean updateOffer(OfferUpdateDTO offerUpdateDTO, Long offerId);

    boolean deleteOffer(Long id);
}
