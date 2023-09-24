package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.PictureUploadDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import jakarta.validation.Valid;

import java.util.List;

public interface PictureService {

    List<Picture> findAll();

    boolean uploadPicture(PictureUploadDTO pictureUploadDTO, Long routeId);
}
