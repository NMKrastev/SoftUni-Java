package com.example.A2_CarDealer.services.supplier;

import jakarta.xml.bind.JAXBException;

public interface SupplierService {

    String findAllLocalSuppliersByPartsCount() throws JAXBException;
}
