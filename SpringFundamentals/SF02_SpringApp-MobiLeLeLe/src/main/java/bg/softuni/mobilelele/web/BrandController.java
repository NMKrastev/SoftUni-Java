package bg.softuni.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrandController {

    @GetMapping("/brands/all")
    public ModelAndView showAllBrands(ModelAndView modelAndView) {

        modelAndView.setViewName("brands");

        return modelAndView;
    }
}
