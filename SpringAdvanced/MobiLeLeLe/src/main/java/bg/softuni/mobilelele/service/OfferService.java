package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.dto.OfferUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    List<OfferDetailsDTO> findAllOffers();

    Optional<OfferDetailsDTO> findOfferById(Long id);

    void addOffer(AddOfferDTO addOfferDTO);

    OfferUpdateDTO findOfferToUpdate(Long id);

    boolean updateOffer(OfferUpdateDTO offerUpdateDTO, Long offerId);

    boolean deleteOffer(Long id);

    Page<OfferDetailsDTO> getAllOffers(Pageable pageable);
}
