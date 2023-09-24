package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private static String categoryName;
    private static final String CATEGORY_PEDESTRIAN = "PEDESTRIAN";
    private static final String CATEGORY_BICYCLE = "BICYCLE";
    private static final String CATEGORY_MOTORCYCLE = "MOTORCYCLE";
    private static final String CATEGORY_CAR = "CAR";

    private final RouteService routeService;

    @Autowired
    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) {

        final Route route = routeService.getMostCommented();

        modelAndView.addObject("mostCommented", route);

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

        final List<Route> routes = this.routeService.findRouteByCategory(CATEGORY_PEDESTRIAN);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("pedestrian");

        return modelAndView;
    }

    @GetMapping("/bicycle")
    public ModelAndView bicycle(ModelAndView modelAndView) {

        final List<Route> routes = this.routeService.findRouteByCategory(CATEGORY_BICYCLE);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("bicycle");

        return modelAndView;
    }

    @GetMapping("/motorcycle")
    public ModelAndView motorcycle(ModelAndView modelAndView) {

        final List<Route> routes = this.routeService.findRouteByCategory(CATEGORY_MOTORCYCLE);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("motorcycle");

        return modelAndView;
    }

    @GetMapping("/car")
    public ModelAndView car(ModelAndView modelAndView) {

        final List<Route> routes = this.routeService.findRouteByCategory(CATEGORY_CAR);

        modelAndView.addObject("routes", routes);

        modelAndView.setViewName("car");

        return modelAndView;
    }
}
