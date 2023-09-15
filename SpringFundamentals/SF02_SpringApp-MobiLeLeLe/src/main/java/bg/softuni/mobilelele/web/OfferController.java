package bg.softuni.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {

    @GetMapping("/offers/all")
    public ModelAndView showOffers(ModelAndView modelAndView) {

        modelAndView.setViewName("offers");

        return modelAndView;
    }

    @GetMapping("/offers/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {

        modelAndView.setViewName("offer-add");

        return modelAndView;
    }
}
