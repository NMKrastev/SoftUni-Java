package bg.softuni.mobilelele.model.mapper;

import bg.softuni.mobilelele.model.dto.ModelDTO;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    ModelDTO modelEntityToModelDto(ModelEntity modelEntity);
}
