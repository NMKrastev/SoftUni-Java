package com.example.A2_CarDealer.services.customer;

import jakarta.xml.bind.JAXBException;

public interface CustomerService {

    String findAllCustomersAndOrderByCriteria() throws JAXBException;

    String findAllCustomersWithTotalSalesAndMoneySpent() throws JAXBException;
}
