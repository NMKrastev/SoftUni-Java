package com.example.A2_CarDealer.services.car;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface CarService {

    String findAllCarsFromMakeToyota() throws JAXBException;

    String findAllCarsAndTheirParts() throws JAXBException;
}
