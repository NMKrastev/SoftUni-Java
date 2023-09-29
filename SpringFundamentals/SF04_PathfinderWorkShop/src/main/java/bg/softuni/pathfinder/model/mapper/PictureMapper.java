package bg.softuni.pathfinder.model.mapper;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    PictureUrlDTO pictureToPictureUrlDTO(Picture picture);
}
