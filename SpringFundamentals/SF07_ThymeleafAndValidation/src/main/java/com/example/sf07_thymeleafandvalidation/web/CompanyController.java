package com.example.sf07_thymeleafandvalidation.web;

import com.example.sf07_thymeleafandvalidation.model.dto.CompanyDTO;
import com.example.sf07_thymeleafandvalidation.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {

        this.companyService = companyService;
    }

    @ModelAttribute("companyDTO")
    public void initCompanyCreationModel(Model model) {
        model.addAttribute("companyDTO", new CompanyDTO());
    }

    @GetMapping("/all")
    public ModelAndView getAllCompanies(ModelAndView modelAndView) {

        final List<CompanyDTO> companiesDTO = this.companyService.getAllCompanies();

        modelAndView.addObject("companies", companiesDTO);

        modelAndView.setViewName("company-all");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addCompany(ModelAndView modelAndView) {

        modelAndView.setViewName("company-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addCompany(ModelAndView modelAndView,
                                   @Valid CompanyDTO companyDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("companyDTO", companyDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.companyDTO", bindingResult);

            modelAndView.setViewName("redirect:/companies/add");

            return modelAndView;
        }

        boolean isRegistered = this.companyService.registerCompany(companyDTO);

        if (isRegistered) {

            modelAndView.setViewName("redirect:/companies/all");

        } else {

            modelAndView.setViewName("redirect:/companies/add");

        }

        return modelAndView;
    }

    @GetMapping("/details/{name}")
    public ModelAndView getCompanyDetails(ModelAndView modelAndView,
                                          @PathVariable("name") String name) {

        final CompanyDTO company = this.companyService.findCompanyByName(name);

        modelAndView.addObject("company", company);

        modelAndView.setViewName("company-details");

        return modelAndView;
    }

    @GetMapping("/delete/{name}")
    public ModelAndView deleteCompany(ModelAndView modelAndView,
                                      @PathVariable("name") String name) {

        boolean isDeleted = this.companyService.deleteCompany(name);

        if (isDeleted) {

            modelAndView.setViewName("redirect:/companies/all");

        } else {

            modelAndView.setViewName(String.format("redirect:/companies/details/%s", name));

        }

        return modelAndView;
    }
}
