package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.RouteLearnMoreDTO;
import bg.softuni.pathfinder.model.dto.RouteRegisterDTO;
import bg.softuni.pathfinder.model.entity.Route;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface RouteService {

    Route getMostCommented();

    Optional<Route> findById(Long id);

    List<Route> findAllRoutes();

    List<Route> findRouteByCategory(String categoryName);

    boolean addNewRoute(RouteRegisterDTO routeDTO);
}
