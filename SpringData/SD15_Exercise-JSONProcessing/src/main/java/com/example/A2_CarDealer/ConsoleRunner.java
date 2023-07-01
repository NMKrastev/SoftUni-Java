package com.example.A2_CarDealer;

import com.example.A2_CarDealer.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner;
    private final SeedService seedService;
    private String output;
    private int taskNumber;

    @Autowired
    public ConsoleRunner(Scanner scanner, SeedService seedService) {
        this.scanner = scanner;
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.print("Enter task number ot 0 to exit: ");
        this.taskNumber = Integer.parseInt(this.scanner.nextLine());

        while (this.taskNumber != 0) {

            switch (this.taskNumber) {

                case 1 -> this.seedService.seedAllData();
            }


            System.out.print("Enter task number ot 0 to exit: ");
            this.taskNumber = Integer.parseInt(this.scanner.nextLine());

        }
    }
}
