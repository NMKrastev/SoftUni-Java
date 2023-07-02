package com.example.A2_CarDealer;

import com.example.A2_CarDealer.services.car.CarService;
import com.example.A2_CarDealer.services.seed.SeedService;
import com.example.A2_CarDealer.services.customer.CustomerService;
import com.example.A2_CarDealer.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner;
    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;
    private String output;
    private int taskNumber;

    @Autowired
    public ConsoleRunner(Scanner scanner, SeedService seedService, CustomerService customerService, CarService carService, SupplierService supplierService) {
        this.scanner = scanner;
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.print("Enter task number ot 0 to exit: ");
        this.taskNumber = Integer.parseInt(this.scanner.nextLine());

        while (this.taskNumber != 0) {

            switch (this.taskNumber) {

                case 1 -> this.seedService.seedAllData();
                case 2 -> this.output = this.customerService.findAllCustomersAndOrderByCriteria();
                case 3 -> this.output = this.carService.findAllCarsFromMakeToyota();
                case 4 -> this.output = this.supplierService.findAllLocalSuppliersByPartsCount();
                case 5 -> this.output = this.carService.findAllCarsAndTheirParts();
                case 6 -> this.output = this.customerService.findAllCustomersWithTotalSalesAndMoneySpent();
            }

            System.out.println(this.output);

            System.out.print("Enter task number ot 0 to exit: ");
            this.taskNumber = Integer.parseInt(this.scanner.nextLine());

        }
    }
}
