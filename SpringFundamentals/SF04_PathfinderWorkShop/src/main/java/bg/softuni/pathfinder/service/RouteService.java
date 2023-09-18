package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.RouteLearnMoreDTO;
import bg.softuni.pathfinder.model.entity.Route;

import java.util.Optional;

public interface RouteService {

    Route getMostCommented();

    Optional<Route> findById(Long id);
}
