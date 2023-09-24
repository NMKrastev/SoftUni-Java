package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.repository.PictureRepository;
import bg.softuni.pathfinder.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<Picture> findAll() {
        return this.pictureRepository.findAll();
    }
}
