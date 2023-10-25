package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.BrandDTO;
import bg.softuni.mobilelele.service.CarBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BrandController {

    private final CarBrandService brandService;

    public BrandController(CarBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/all")
    public ModelAndView showAllBrands(ModelAndView modelAndView) {

        final List<BrandDTO> allBrands = this.brandService.getAllBrands();

        modelAndView.addObject("allBrands", allBrands);

        modelAndView.setViewName("brands");

        return modelAndView;
    }
}
