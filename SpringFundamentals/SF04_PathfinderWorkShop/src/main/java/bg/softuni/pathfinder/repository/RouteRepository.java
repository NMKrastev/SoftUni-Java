package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    //Query("SELECT r From Route AS r ORDER BY size(r.comments) DESC LIMIT 1")
    Route findFirstByOrderByCommentsDesc();

    Optional<Route> findByGpxCoordinates(String gpxCoordinates);

    List<Route> findRoutesByCategoriesIn(Set<Category> category);
}
