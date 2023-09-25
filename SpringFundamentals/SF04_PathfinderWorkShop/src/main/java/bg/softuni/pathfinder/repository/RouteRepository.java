package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.dto.routeDTO.MostCommentedDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.AllRoutesDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.RouteDetailDTO;
import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("""
            SELECT NEW bg.softuni.pathfinder.model.dto.routeDTO.MostCommentedDTO(r.id, r.name, p.url)
            FROM Route AS r
            JOIN Picture AS p ON p.route.id = r.id
            ORDER BY size(r.comments) DESC LIMIT 1
            """)
    MostCommentedDTO getMostCommentedRoute();


    List<Route> findAll();

    @Query("""
            SELECT NEW bg.softuni.pathfinder.model.dto.routeDTO.RouteDetailDTO(r.id, u.fullName, r.description, r.videoUrl, r.level)
            FROM Route AS r
            JOIN User AS u ON r.author.id = u.id
            WHERE r.id = ?1
            """)
    RouteDetailDTO getRouteDetails(Long id);

    //Query("SELECT r From Route AS r ORDER BY size(r.comments) DESC LIMIT 1")

    Optional<Route> findByGpxCoordinates(String gpxCoordinates);


    List<Route> findRoutesByCategoriesIn(Set<Category> categories);
}
