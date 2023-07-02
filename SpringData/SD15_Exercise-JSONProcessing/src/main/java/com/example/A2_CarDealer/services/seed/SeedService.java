package com.example.A2_CarDealer.services.seed;

import java.io.FileNotFoundException;

import static com.example.A2_CarDealer.constants.Messages.DATA_SEEDING_PROCEDURE_FINISHED;

public interface SeedService {

    String seedSuppliers() throws FileNotFoundException;

    String seedParts() throws FileNotFoundException;

    String seedCars() throws FileNotFoundException;

    String seedCustomers() throws FileNotFoundException;

    String populateSales();

    default void seedAllData() throws FileNotFoundException {

        final StringBuilder sb = new StringBuilder();

        sb.append(this.seedSuppliers()).append(System.lineSeparator());
        sb.append(this.seedParts()).append(System.lineSeparator());
        sb.append(this.seedCars()).append(System.lineSeparator());
        sb.append(this.seedCustomers()).append(System.lineSeparator());
        sb.append(this.populateSales()).append(System.lineSeparator());

        System.out.print(sb);
        System.out.println(DATA_SEEDING_PROCEDURE_FINISHED);
    }
}
