package bg.softuni.resellerapp.web;

import bg.softuni.resellerapp.model.dto.AddOfferDTO;
import bg.softuni.resellerapp.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {

        this.offerService = offerService;
    }

    @ModelAttribute("addOfferDTO")
    public void initAddOfferModel(Model model) {
        model.addAttribute("addOfferDTO", new AddOfferDTO());
    }

    @GetMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {

        modelAndView.setViewName("offer-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView,
                                 @Valid AddOfferDTO addOfferDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);

            modelAndView.setViewName("redirect:/offers/add");

            return modelAndView;
        }

        boolean isOfferAdded = this.offerService.addOffer(addOfferDTO);

        if (isOfferAdded) {
            modelAndView.setViewName("redirect:/home");
        } else {

            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);

            modelAndView.setViewName("redirect:/offers/add");
        }

        return modelAndView;
    }
}
