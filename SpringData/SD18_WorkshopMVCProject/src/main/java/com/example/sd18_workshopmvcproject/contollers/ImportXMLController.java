package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.services.company.CompanyService;
import com.example.sd18_workshopmvcproject.services.employee.EmployeeService;
import com.example.sd18_workshopmvcproject.services.project.ProjectService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ImportXMLController {

    private final CompanyService companyService;
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    @Autowired
    public ImportXMLController(CompanyService companyService, ProjectService projectService, EmployeeService employeeService) {
        this.companyService = companyService;
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/import/xml")
    public ModelAndView importXml(ModelAndView modelAndView) {

        modelAndView.setViewName("xml/import-xml");

        final boolean areCompaniesImported = this.companyService.areImported();
        final boolean areProjectsImported = this.projectService.areImported();
        final boolean areEmployeesImported = this.employeeService.areImported();

        boolean[] importStatuses = {areCompaniesImported, areProjectsImported, areEmployeesImported};

        modelAndView.addObject("areImported", importStatuses);

        return modelAndView;
    }

    @GetMapping("/import/companies")
    public ModelAndView viewImportCompanies(ModelAndView modelAndView) throws IOException {

        modelAndView.setViewName("xml/import-companies");

        final String companiesXML = this.companyService.getXMLContent();

        modelAndView.addObject("companies", companiesXML);

        return modelAndView;
    }

    @PostMapping("/import/companies")
    public ModelAndView importCompanies(ModelAndView modelAndView) throws JAXBException, IOException {

        this.companyService.importCompanies();

        modelAndView.setViewName("redirect:/import/xml");

        return modelAndView;
    }

    @GetMapping("import/projects")
    public ModelAndView viewImportProjects(ModelAndView modelAndView) throws IOException {

        modelAndView.setViewName("xml/import-projects");

        final String projectsXML = this.projectService.getXMLContent();

        modelAndView.addObject("projects", projectsXML);

        return modelAndView;
    }

    @PostMapping("import/projects")
    public ModelAndView importProjects(ModelAndView modelAndView) throws IOException, JAXBException {

        this.projectService.importProjects();

        modelAndView.setViewName("redirect:/import/xml");

        return modelAndView;
    }

    @GetMapping("import/employees")
    public ModelAndView viewImportEmployees(ModelAndView modelAndView) throws IOException {

        modelAndView.setViewName("xml/import-employees");

        final String employeesXML = this.employeeService.getXMLContent();

        modelAndView.addObject("employees", employeesXML);

        return modelAndView;
    }

    @PostMapping("import/employees")
    public ModelAndView importEmployees(ModelAndView modelAndView) throws JAXBException, IOException {

        this.employeeService.importEmployees();

        modelAndView.setViewName("redirect:/import/xml");

        return modelAndView;
    }
}
