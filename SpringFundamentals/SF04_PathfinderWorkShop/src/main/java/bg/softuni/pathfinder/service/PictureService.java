package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUploadDTO;
import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;

import java.util.List;

public interface PictureService {

    List<PictureUrlDTO> findAllPictures();

    boolean uploadPicture(PictureUploadDTO pictureUploadDTO, Long routeId);

    List<PictureUrlDTO> findAllPicturesByRouteId(Long routeId);
}
