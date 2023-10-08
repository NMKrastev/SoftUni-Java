package bg.softuni.resellerapp.web;

import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.service.OfferService;
import bg.softuni.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final UserService userService;

    public HomeController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        final List<Offer> allOtherOffers = this.offerService.findAllOtherUsersOffers();

        final List<Offer> userOffers = this.offerService.findUserOffers();

        final List<Offer> userBoughtItems = this.offerService.findUserBoughtItems();

        Map<String, Object> map =
                Map.of("allOtherOffers", allOtherOffers,
                        "userOffers", userOffers,
                        "userBoughtItems", userBoughtItems);

        modelAndView.addAllObjects(map);

        return modelAndView;
    }
}
