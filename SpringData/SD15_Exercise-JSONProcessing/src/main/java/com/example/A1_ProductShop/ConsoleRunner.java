package com.example.A1_ProductShop;

import com.example.A1_ProductShop.services.category.CategoryService;
import com.example.A1_ProductShop.services.product.ProductService;
import com.example.A1_ProductShop.services.seed.SeedService;
import com.example.A1_ProductShop.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.example.A1_ProductShop.constants.Constants.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final Scanner scanner;

    private String output;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService, Scanner scanner) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.scanner = scanner;
    }

    //If the paths for seeding data don't work just remove "SD15_Exercise-JSONProcessing" from them
    @Override
    public void run(String... args) throws Exception {

        System.out.print(ENTER_TASK_NUMBER);
        int taskNumber = Integer.parseInt(this.scanner.nextLine());

        while (taskNumber != 0) {

            switch (taskNumber) {

                case 1 -> this.output = this.seedService.seedAllData();

                case 2 -> {
                    System.out.print(ENTER_MIN_PRICE_RANGE);
                    final BigDecimal minRangePrice = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));

                    System.out.print(ENTER_MAX_PRICE_RANGE);
                    final BigDecimal maxRangePrice = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));

                    this.output = this.productService.findAllProductsInPriceRange(minRangePrice, maxRangePrice);
                }

                case 3 -> this.output = this.userService.findAllUsersWithSoldProductsToAtLeastOneBuyer();

                case 4 -> this.output = this.categoryService.getCategoriesByProductSummary();

                case 5 -> this.output = this.userService.findUsersWithSoldProductsAndCount();

                default -> this.output = String.format(TASK_NUMBER_DOES_NOT_EXISTS, taskNumber);
            }

            System.out.println(output);

            System.out.print(ENTER_TASK_NUMBER);
            taskNumber = Integer.parseInt(this.scanner.nextLine());
        }
    }
}
