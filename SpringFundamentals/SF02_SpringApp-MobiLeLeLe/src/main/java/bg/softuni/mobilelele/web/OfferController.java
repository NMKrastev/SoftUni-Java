package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/all")
    public ModelAndView showOffers(ModelAndView modelAndView) {

        final List<OfferEntity> allOffers = this.offerService.findAllOffers();

        modelAndView.addObject("offers", allOffers);

        modelAndView.setViewName("offers");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {

        modelAndView.setViewName("offer-add");

        return modelAndView;
    }

    @GetMapping("/details")
    public ModelAndView details(ModelAndView modelAndView) {

        modelAndView.setViewName("details");

        return modelAndView;
    }

    //TODO: Create Offer details DTO to show all needed data.
    //TODO: Convert the date in the correct format!

    @GetMapping("/details/{id}")
    public ModelAndView details(ModelAndView modelAndView,
                                @PathVariable Long id) {

        OfferEntity offer = this.offerService.findOfferById(id);

        modelAndView.addObject("offer", offer);

        modelAndView.setViewName("details");

        return modelAndView;

    }
}
