package bg.softuni.mobilelele.model.mapper;

import bg.softuni.mobilelele.model.dto.BrandDTO;
import bg.softuni.mobilelele.model.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDTO brandEntitytoBrandDto(BrandEntity brandEntity);
}
