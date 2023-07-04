package com.example.A2_CarDealer.services.sale;


import jakarta.xml.bind.JAXBException;

public interface SaleService {

    String findAllSalesWithInformationAboutCarAndCustomer() throws JAXBException;
}
