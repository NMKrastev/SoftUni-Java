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
    public String about() {

        return "about";
    }

    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    @GetMapping("/user/register")
    public String register() {

        return "register";
    }

    @GetMapping("/routes/details/{id}")
    public ModelAndView learMore(ModelAndView modelAndView, @PathVariable String id) {

        final Long routeID = Long.valueOf(id);

        final Route route = routeService.findById(Long.valueOf(id)).get();

        String fullName = route.getAuthor().getFullName();

        modelAndView.addObject("route", route);

        modelAndView.setViewName("route-details");

        return modelAndView;
    }

    @GetMapping("/routes")
    public ModelAndView routes(ModelAndView modelAndView) {

        final List<Route> allRoutes = this.routeService.findAllRoutes();

        modelAndView.addObject("routes", allRoutes);

        modelAndView.setViewName("routes");

        return modelAndView;
    }
}
