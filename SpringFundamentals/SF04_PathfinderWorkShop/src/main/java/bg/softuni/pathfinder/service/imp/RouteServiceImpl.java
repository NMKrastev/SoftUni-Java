package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.MostCommentedDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.AllRoutesDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.RouteDetailDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.RouteRegisterDTO;
import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Picture;
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

import java.io.IOException;
import java.util.*;

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
    public MostCommentedDTO getMostCommented() {

        return routeRepository.getMostCommentedRoute();
    }

    @Override
    public RouteDetailDTO getRouteDetails(Long id) {

        return routeRepository.getRouteDetails(id);
    }

    @Override
    public List<AllRoutesDTO> findAllRoutes() {

        final List<Route> allRoutes = this.routeRepository.findAll();

        final List<AllRoutesDTO> allRoutesDTOS = getRoutesDetails(allRoutes);;

        return allRoutesDTOS;
    }

    @Override
    public List<AllRoutesDTO> findRouteByCategory(String categoryName) {

        final Category categoryByName = this.categoryService.findCategoryByName(CategoryEnumType.valueOf(categoryName));

        final Set<Category> categories = new HashSet<>(Set.of(categoryByName));

        final List<Route> routesByCategories = this.routeRepository.findRoutesByCategoriesIn(categories);

        final List<AllRoutesDTO> routesByCategory = getRoutesDetails(routesByCategories);

        return routesByCategory;
    }

    private List<AllRoutesDTO> getRoutesDetails(List<Route> routes) {

        final List<AllRoutesDTO> allRoutesDTOS = new ArrayList<>();

        for (Route route : routes) {

            final Set<PictureUrlDTO> pictures = new LinkedHashSet<>();

            for (Picture picture : route.getPictures()) {
                pictures.add(new PictureUrlDTO(picture.getUrl()));
            }

            final AllRoutesDTO allRoutesDTO = AllRoutesDTO.builder()
                    .id(route.getId())
                    .name(route.getName())
                    .description(route.getDescription())
                    .picturesUrl(pictures)
                    .build();

            allRoutesDTOS.add(allRoutesDTO);
        }

        return allRoutesDTOS;
    }

    @Override
    public boolean addNewRoute(RouteRegisterDTO routeDTO) {

        // TODO: 24.9.2023 г. Could be transferred to the controller
        // TODO: 24.9.2023 г. Should make validation of the structure of the file
        if (routeDTO.getGpxCoordinates().isEmpty()) {

            this.LOGGER.error("GPX Coordinates file is empty.");

            return false;
        }

        final byte[] fileBytes;

        try {

            fileBytes = routeDTO.getGpxCoordinates().getBytes();

        } catch (IOException e) {

            this.LOGGER.error("Error getting GPX Coordinates to Bytes: " + e.getMessage());

            return false;
        }

        final String gpxCoordinates = new String(fileBytes);

        final Optional<Route> optionalRoute = this.routeRepository.findByGpxCoordinates(gpxCoordinates);

        if (optionalRoute.isPresent()) {

            this.LOGGER.info("Route with the same GPX Coordinates already exists!");

            return false;
        }

        final Set<String> routeDTOCategories = routeDTO.getCategories();

        final Set<Category> categories = new HashSet<>();

        for (String name : routeDTOCategories) {
            Category categoryByName = this.categoryService.findCategoryByName(CategoryEnumType.valueOf(name));
            categories.add(categoryByName);
        }

        final Route newRoute = this.mapper.map(routeDTO, Route.class);

        newRoute.setAuthor(this.userService.findUser(this.currentUser.getUsername()));
        newRoute.setGpxCoordinates(gpxCoordinates);
        newRoute.setCategories(categories);

        this.routeRepository.saveAndFlush(newRoute);

        return true;
    }

    @Override
    public Optional<Route> findById(Long routeId) {

        return this.routeRepository.findById(routeId);
    }
}
