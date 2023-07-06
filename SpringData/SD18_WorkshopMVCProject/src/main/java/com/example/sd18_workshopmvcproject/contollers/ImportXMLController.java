package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.services.company.CompanyService;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ImportXMLController {

    private CompanyService companyService;

    public ImportXMLController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/import/xml")
    public ModelAndView importXml(ModelAndView modelAndView) {

        modelAndView.setViewName("xml/import-xml");

        final boolean areCompaniesImported = this.companyService.areImported();

        boolean[] importStatuses = {areCompaniesImported, false, false};

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
}
