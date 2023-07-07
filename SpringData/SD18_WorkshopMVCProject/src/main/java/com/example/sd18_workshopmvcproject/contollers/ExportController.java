package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.services.employee.EmployeeService;
import com.example.sd18_workshopmvcproject.services.project.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExportController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ExportController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }


    @GetMapping("export/project-if-finished")
    public ModelAndView exportFinishedProjects(ModelAndView modelAndView) {

        modelAndView.setViewName("export/export-project-if-finished");

        final String exportedFinishedProjects = this.projectService.exportFinishedProjects();

        modelAndView.addObject("projectsIfFinished", exportedFinishedProjects);

        return modelAndView;
    }

    @GetMapping("export/employees-above")
    public ModelAndView exportEmployeesAboveAgeOf25(ModelAndView modelAndView) {

        modelAndView.setViewName("export/export-employees-with-age");

        final String exportedEmployeesAboveAgeOf25 = this.employeeService.exportEmployeesAboveAgeOf25();

        modelAndView.addObject("employeesAbove", exportedEmployeesAboveAgeOf25);

        return modelAndView;
    }
}
