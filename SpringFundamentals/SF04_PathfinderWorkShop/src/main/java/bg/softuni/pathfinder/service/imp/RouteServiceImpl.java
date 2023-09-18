package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.dto.RouteLearnMoreDTO;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper mapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper mapper) {
        this.routeRepository = routeRepository;
        this.mapper = mapper;
    }

    @Override
    public Route getMostCommented() {

        return routeRepository.findFirstByOrderByCommentsDesc();
    }

    @Override
    public Optional<Route> findById(Long id) {

        return routeRepository.findById(id);
    }

    @Override
    public List<Route> findAllRoutes() {
        return this.routeRepository.findAll();
    }
}
