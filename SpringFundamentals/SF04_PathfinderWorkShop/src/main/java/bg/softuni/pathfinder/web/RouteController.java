package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.RouteRegisterDTO;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @ModelAttribute("routeDTO")
    public void initRouteRegistration(Model model) {
        model.addAttribute("routeDTO", new RouteRegisterDTO());
    }

    @GetMapping()
    public ModelAndView routes(ModelAndView modelAndView) {

        final List<Route> allRoutes = this.routeService.findAllRoutes();

        modelAndView.addObject("routes", allRoutes);

        modelAndView.setViewName("routes");

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView learMore(ModelAndView modelAndView, @PathVariable("id") String id) {

        final Long routeId = Long.valueOf(id);

        final Route route = routeService.findById(routeId).get();

        modelAndView.addObject("route", route);

        modelAndView.setViewName("route-details");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addRoute(ModelAndView modelAndView) {

        modelAndView.setViewName("add-route");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(ModelAndView modelAndView,
                                 @Valid RouteRegisterDTO routeDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || routeDTO.getCategories().isEmpty()) {

            redirectAttributes.addFlashAttribute("routeDTO", routeDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeDTO", bindingResult);

            modelAndView.setViewName("redirect:/routes/add");

            return modelAndView;
        }

        final boolean isRouteAdded = this.routeService.addNewRoute(routeDTO);

        if (isRouteAdded) {
            modelAndView.setViewName("redirect:/routes");
        } else {
            modelAndView.setViewName("add-route");
        }

        return modelAndView;

    }
}
