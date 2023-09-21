package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.dto.RouteRegisterDTO;
import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.enums.CategoryEnumType;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.CategoryService;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private final Logger LOGGER = LoggerFactory.getLogger(RouteService.class);
    private final RouteRepository routeRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, CategoryService categoryService,
                            UserService userService, ModelMapper mapper, CurrentUser currentUser) {
        this.routeRepository = routeRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.mapper = mapper;
        this.currentUser = currentUser;
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

    @Override
    public boolean addNewRoute(RouteRegisterDTO routeDTO) {

        final Optional<Route> optionalRoute = this.routeRepository.findByGpxCoordinates(routeDTO.getGpxCoordinates());

        if (optionalRoute.isPresent()) {
            this.LOGGER.info("Route with the same GPX Coordinates already exists!");
            return false;
        }

        Set<String> routeDTOCategories = routeDTO.getCategories();

        final Set<Category> categories = new HashSet<>();

        for (String name : routeDTOCategories) {
            Category categoryByName = this.categoryService.findCategoryByName(CategoryEnumType.valueOf(name));
            categories.add(categoryByName);
        }

        final Route newRoute = this.mapper.map(routeDTO, Route.class);
        newRoute.setAuthor(this.userService.findUser(this.currentUser.getUsername()));
        newRoute.setCategories(categories);

        final Route saved = this.routeRepository.saveAndFlush(newRoute);

        return true;
    }
}
