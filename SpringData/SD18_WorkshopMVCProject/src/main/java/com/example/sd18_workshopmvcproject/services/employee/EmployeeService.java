package com.example.sd18_workshopmvcproject.services.employee;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface EmployeeService {

    boolean areImported();

    String getXMLContent() throws IOException;

    void importEmployees() throws JAXBException, IOException;

    String exportEmployeesAboveAgeOf25();
}
