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

    @Query("""
            SELECT NEW bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO(p.url)
            FROM Picture AS p""")
    List<PictureUrlDTO> findAllPictures();

    Optional<Picture> findByTitleAndAndUrl(String title, String pictureUrl);

    @Query("""
            SELECT NEW bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO(p.url)
            FROM Picture AS p
            WHERE p.route.id = ?1""")
    List<PictureUrlDTO> findAllPicturesByRouteId(Long routeId);
}
