package bg.softuni.mobilelele.model.mapper;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.dto.OfferUpdateDTO;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);

    OfferUpdateDTO offerEntityToOfferDto(OfferEntity offerEntity);

    OfferEntity updateOfferDtoToOfferEntity(OfferUpdateDTO offerUpdateDTO);

    OfferDetailsDTO offerEntityToOfferDetailsDto(OfferEntity offerEntity);
}
