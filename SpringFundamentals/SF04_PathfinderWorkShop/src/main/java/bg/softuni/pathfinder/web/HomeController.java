package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

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

        modelAndView.setViewName("pedestrian");

        return modelAndView;
    }

    @GetMapping("/bicycle")
    public ModelAndView bicycle(ModelAndView modelAndView) {

        modelAndView.setViewName("bicycle");

        return modelAndView;
    }

    @GetMapping("/motorcycle")
    public ModelAndView motorcycle(ModelAndView modelAndView) {

        modelAndView.setViewName("motorcycle");

        return modelAndView;
    }

    @GetMapping("/car")
    public ModelAndView car(ModelAndView modelAndView) {

        modelAndView.setViewName("car");

        return modelAndView;
    }
}
