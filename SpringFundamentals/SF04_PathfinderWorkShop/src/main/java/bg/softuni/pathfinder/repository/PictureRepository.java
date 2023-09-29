package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    List<Picture> findAll();

    Optional<Picture> findByTitleAndAndUrl(String title, String pictureUrl);

}
