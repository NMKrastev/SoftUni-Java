package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route getMostCommented() {

        return routeRepository.findFirstByOrderByCommentsDesc();
    }

    @Override
    public Optional<Route> findById(Long id) {

        return routeRepository.findById(id);
    }
}
