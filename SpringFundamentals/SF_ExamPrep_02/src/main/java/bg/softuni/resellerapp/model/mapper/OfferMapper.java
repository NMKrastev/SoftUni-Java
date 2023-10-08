package bg.softuni.resellerapp.model.mapper;

import bg.softuni.resellerapp.model.dto.AddOfferDTO;
import bg.softuni.resellerapp.model.dto.UsersOffersDTO;
import bg.softuni.resellerapp.model.entity.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    Offer addOfferDtoToOffer(AddOfferDTO addOfferDTO);

    UsersOffersDTO offerToOfferDto(Offer offer);
}
