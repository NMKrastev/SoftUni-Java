package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.AllRoutesDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.MostCommentedDTO;
import bg.softuni.pathfinder.service.PictureService;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private static final String CATEGORY_PEDESTRIAN = "PEDESTRIAN";
    private static final String CATEGORY_BICYCLE = "BICYCLE";
    private static final String CATEGORY_MOTORCYCLE = "MOTORCYCLE";
    private static final String CATEGORY_CAR = "CAR";

    private final RouteService routeService;
    private final PictureService pictureService;

    @Autowired
    public HomeController(RouteService routeService, PictureService pictureService) {
        this.routeService = routeService;
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) {

        final MostCommentedDTO mostCommented = this.routeService.getMostCommented();

        final List<PictureUrlDTO> pictures = this.pictureService.findAllPictures();

        modelAndView.addObject("mostCommented", mostCommented);
        modelAndView.addObject("pictures", pictures);

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView about(ModelAndView modelAndView) {

        modelAndView.setViewName("about");

        return modelAndView;
    }

    @GetMapping("/pedestrian")
    public ModelAndView pedestrian(ModelAndView modelAndView) {

        final List<AllRoutesDTO> routes = this.routeService.findRouteByCategory(CATEGORY_PEDESTRIAN);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("pedestrian");

        return modelAndView;
    }

    @GetMapping("/bicycle")
    public ModelAndView bicycle(ModelAndView modelAndView) {

        final List<AllRoutesDTO> routes = this.routeService.findRouteByCategory(CATEGORY_BICYCLE);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("bicycle");

        return modelAndView;
    }

    @GetMapping("/motorcycle")
    public ModelAndView motorcycle(ModelAndView modelAndView) {

        final List<AllRoutesDTO> routes = this.routeService.findRouteByCategory(CATEGORY_MOTORCYCLE);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("motorcycle");

        return modelAndView;
    }

    @GetMapping("/car")
    public ModelAndView car(ModelAndView modelAndView) {

        final List<AllRoutesDTO> routes = this.routeService.findRouteByCategory(CATEGORY_CAR);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("car");

        return modelAndView;
    }
}
