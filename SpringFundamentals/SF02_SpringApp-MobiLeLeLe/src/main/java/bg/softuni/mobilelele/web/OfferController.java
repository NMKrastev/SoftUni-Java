package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public ModelAndView showOffers(ModelAndView modelAndView) {

        final List<OfferEntity> allOffers = this.offerService.findAllOffers();

        modelAndView.addObject("offers", allOffers);

        modelAndView.setViewName("offers");

        return modelAndView;
    }

    @GetMapping("/offers/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {

        modelAndView.setViewName("offer-add");

        return modelAndView;
    }
}
