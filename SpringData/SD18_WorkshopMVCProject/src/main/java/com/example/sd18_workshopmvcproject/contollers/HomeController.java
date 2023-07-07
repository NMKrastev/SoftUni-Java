package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoggedInDTO;
import com.example.sd18_workshopmvcproject.services.company.CompanyService;
import com.example.sd18_workshopmvcproject.services.employee.EmployeeService;
import com.example.sd18_workshopmvcproject.services.project.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final UserController userController;
    private final CompanyService companyService;
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public HomeController(UserController userController, CompanyService companyService,
                          ProjectService projectService, EmployeeService employeeService) {
        this.userController = userController;
        this.companyService = companyService;
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        if (this.userController.isUserLoggedIn()) {

            final UserLoggedInDTO loggedInUser = this.userController.getLoggedInUser();

            modelAndView.addObject("username", loggedInUser.getUsername());

            modelAndView.setViewName("index");

            return modelAndView;
        }

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        modelAndView.setViewName("home");

        boolean importStatuses = this.companyService.areImported() &&
                this.projectService.areImported() &&
                this.employeeService.areImported();

        modelAndView.addObject("areImported", importStatuses);

        return modelAndView;
    }

}
