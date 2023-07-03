package com.example.A2_CarDealer.services.car;

import java.io.IOException;

public interface CarService {

    String findAllCarsFromMakeToyota() throws IOException;

    String findAllCarsAndTheirParts() throws IOException;
}
