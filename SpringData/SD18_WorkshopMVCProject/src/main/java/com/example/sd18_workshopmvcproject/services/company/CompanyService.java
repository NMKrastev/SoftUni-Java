package com.example.sd18_workshopmvcproject.services.company;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface CompanyService {

    boolean areImported();

    String getXMLContent() throws IOException;

    void importCompanies() throws IOException, JAXBException;
}
