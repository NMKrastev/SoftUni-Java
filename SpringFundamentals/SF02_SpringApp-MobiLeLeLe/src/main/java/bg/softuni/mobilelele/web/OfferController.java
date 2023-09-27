package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.BrandDTO;
import bg.softuni.mobilelele.model.dto.OfferUpdateDTO;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.service.CarBrandService;
import bg.softuni.mobilelele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final CarBrandService brandService;

    public OfferController(OfferService offerService, CarBrandService brandService) {

        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public ModelAndView showOffers(ModelAndView modelAndView) {

        final List<OfferEntity> allOffers = this.offerService.findAllOffers();

        modelAndView.addObject("offers", allOffers);

        modelAndView.setViewName("offers");

        return modelAndView;
    }

    // TODO: 26.9.2023 г. Find a way to do it with ModelAndView
    @GetMapping("/add")
    public String addOffer(Model model) {

        //Alternative for @ModelAttribute
        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", new AddOfferDTO());
        }

        final List<BrandDTO> allBrands = this.brandService.getAllBrands();

        model.addAttribute("brands", allBrands);

        return "offer-add";
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

        this.offerService.addOffer(addOfferDTO);

        modelAndView.setViewName("redirect:/offers/all");

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

    @GetMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable Long id) {

        /*if (!model.containsAttribute("offerUpdateDTO")) {
            model.addAttribute("offerUpdateDTO", new OfferUpdateDTO());
        }*/

        final OfferUpdateDTO offerUpdateDTO = this.offerService.findOfferToUpdate(id);

        final List<BrandDTO> allBrands = this.brandService.getAllBrands();

        model.addAttribute("offerUpdate", offerUpdateDTO);

        model.addAttribute("brands", allBrands);

        return "/update";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(ModelAndView modelAndView,
                               @PathVariable("id") Long offerId,
                               @Valid OfferUpdateDTO offerUpdateDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerUpdateDTO", offerUpdateDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerUpdateDTO", bindingResult);

            modelAndView.setViewName(String.format("redirect:/offers/update/%d", offerId));

            return modelAndView;
        }

        final boolean success = this.offerService.updateOffer(offerUpdateDTO, offerId);

        if (success) {
            modelAndView.setViewName("redirect:/offers/all");
        } else {
            modelAndView.setViewName("update");
        }

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView,
                               @PathVariable("id") Long id) {

        boolean isDeleted = this.offerService.deleteOffer(id);

        if (isDeleted) {
            modelAndView.setViewName("redirect:/offers/all");
        } else {
            modelAndView.setViewName(String.format("redirect:/offers/delete/%d", id));
        }

        return modelAndView;
    }
}
