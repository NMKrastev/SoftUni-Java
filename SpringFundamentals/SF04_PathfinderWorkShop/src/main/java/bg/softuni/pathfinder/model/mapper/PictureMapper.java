package bg.softuni.pathfinder.model.mapper;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    List<PictureUrlDTO> pictureToPictureUrlDTO(List<Picture> picture);
}
