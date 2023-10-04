package com.example.sf07_thymeleafandvalidation.web;

import com.example.sf07_thymeleafandvalidation.model.dto.CompanyDTO;
import com.example.sf07_thymeleafandvalidation.model.dto.EmployeeDTO;
import com.example.sf07_thymeleafandvalidation.service.CompanyService;
import com.example.sf07_thymeleafandvalidation.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {

        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @ModelAttribute("employeeDTO")
    public void initEmployeeCreationDTO(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
    }

    @GetMapping("/all")
    public ModelAndView getAllEmployees(ModelAndView modelAndView) {

        final List<EmployeeDTO> employeesDTO = this.employeeService.getAllEmployees();

        modelAndView.addObject("employees", employeesDTO);

        modelAndView.setViewName("employee-all");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addEmployee(ModelAndView modelAndView) {

        final List<CompanyDTO> companiesDTO = this.companyService.getAllCompanies();

        modelAndView.addObject("allCompanies", companiesDTO);

        modelAndView.setViewName("employee-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addEmployee(ModelAndView modelAndView,
                                    @Valid EmployeeDTO employeeDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("employeeDTO", employeeDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeDTO", bindingResult);

            modelAndView.setViewName("redirect:/employees/add");

            return modelAndView;
        }

        boolean isEmployeeAdded = this.employeeService.addEmployee(employeeDTO);

        if (isEmployeeAdded) {

            modelAndView.setViewName("redirect:/employees/all");

        } else {

            modelAndView.setViewName("redirect:/employees/add");

        }

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView getEmployeeDetails(ModelAndView modelAndView,
                                           @PathVariable("id") Long id) {

        final EmployeeDTO employeeDTO = this.employeeService.findEmployee(id);

        modelAndView.addObject("employee", employeeDTO);

        modelAndView.setViewName("employee-details");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteEmployee(ModelAndView modelAndView,
                                       @PathVariable("id") Long id) {

        boolean isEmployeeDeleted = this.employeeService.deleteEmployee(id);

        if (isEmployeeDeleted) {

            modelAndView.setViewName("redirect:/employees/all");

        } else {

            modelAndView.setViewName(String.format("redirect:/employees/details/%d", id));

        }

        return modelAndView;
    }
}
