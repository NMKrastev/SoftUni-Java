package bg.softuni.resellerapp.web;

import bg.softuni.resellerapp.model.dto.UsersOffersDTO;
import bg.softuni.resellerapp.service.OfferService;
import bg.softuni.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final OfferService offerService;

    public HomeController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        final List<UsersOffersDTO> allOtherOffers = this.offerService.findAllOtherUsersOffers();

        final List<UsersOffersDTO> userOffers = this.offerService.findUserOffers();

        final List<UsersOffersDTO> userBoughtItems = this.offerService.findUserBoughtItems();

        final Map<String, Object> map =
                Map.of("allOtherOffers", allOtherOffers,
                        "userOffers", userOffers,
                        "userBoughtItems", userBoughtItems);

        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @GetMapping("/offers/delete/{id}")
    public ModelAndView deleteOffer(ModelAndView modelAndView,
                                    @PathVariable("id") Long id) {

        boolean isOfferDeleted = this.offerService.deleteOffer(id);

        if (isOfferDeleted) {

            modelAndView.setViewName("redirect:/home");

        } else {
            //TODO: Redirect to some error page
            modelAndView.setViewName("redirect:/");

        }

        return modelAndView;
    }
}
