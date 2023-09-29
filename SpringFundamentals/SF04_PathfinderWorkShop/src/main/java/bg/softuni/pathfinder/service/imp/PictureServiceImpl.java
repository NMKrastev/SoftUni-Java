package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUploadDTO;
import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.mapper.PictureMapper;
import bg.softuni.pathfinder.repository.PictureRepository;
import bg.softuni.pathfinder.service.PictureService;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private final Logger LOGGER = LoggerFactory.getLogger(RouteService.class);
    private final PictureRepository pictureRepository;
    private final UserService userService;
    private final RouteService routeService;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;
    private final PictureMapper pictureMapper;

    public PictureServiceImpl(PictureRepository pictureRepository, UserService userService,
                              RouteService routeService, ModelMapper mapper,
                              CurrentUser currentUser, PictureMapper pictureMapper) {
        this.pictureRepository = pictureRepository;
        this.userService = userService;
        this.routeService = routeService;
        this.mapper = mapper;
        this.currentUser = currentUser;
        this.pictureMapper = pictureMapper;
    }

    @Override
    public List<PictureUrlDTO> findAllPictures() {

        return this.pictureRepository
                .findAllPictures();
    }

    @Override
    public boolean uploadPicture(PictureUploadDTO pictureUploadDTO, Long routeId) {

        Optional<Picture> optionalPicture =
                this.pictureRepository.findByTitleAndAndUrl(pictureUploadDTO.getTitle(), pictureUploadDTO.getPictureUrl());

        if (optionalPicture.isPresent()) {

            this.LOGGER.error("Picture with title and URL already exists!");

            return false;
        }

        final Route route = this.routeService.findById(routeId).get();

        final User author = this.userService.findUser(this.currentUser.getUsername());

        final Picture picture = this.mapper.map(pictureUploadDTO, Picture.class);

        picture.setRoute(route);
        picture.setAuthor(author);

        this.pictureRepository.saveAndFlush(picture);

        return true;
    }

    @Override
    public List<PictureUrlDTO> findAllPicturesByRouteId(Long routeId) {

        return this.pictureRepository.findAllPicturesByRouteId(routeId);
    }
}
