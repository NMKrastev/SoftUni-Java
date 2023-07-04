package com.example.A2_CarDealer.constants;

import java.nio.file.Path;

public enum Paths {

    ;

    public static final Path SUPPLIERS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "files", "suppliers.xml");
    public static final Path PARTS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "files", "parts.xml");
    public static final Path CARS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "files", "cars.xml");
    public static final Path CUSTOMERS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "files", "customers.xml");
    public static final Path ORDERED_CUSTOMERS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "exports", "ordered-customers.xml");
    public static final Path ALL_TOYOTA_CARS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "exports", "toyota-cars.xml");
    public static final Path LOCAL_SUPPLIERS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "exports", "local-suppliers.xml");
    public static final Path CARS_AND_PARTS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "exports", "cars-and-parts.xml");
    public static final Path CUSTOMERS_TOTAL_SALES_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "exports", "customers-total-sales.xml");
    public static final Path SALES_DISCOUNTS_FILE_PATH =
            Path.of("SD17_Exercise-XMLProcessing", "src", "main", "resources", "exports", "sales-discounts.xml");
}
