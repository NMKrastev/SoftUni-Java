package exam.constant;

import java.nio.file.Path;

public enum FilePath {

    ;

    public static final Path TOWNS_FILE_PATH =
            Path.of("src","main", "resources", "files", "xml", "towns.xml");
    public static final Path SHOPS_FILE_PATH =
            Path.of("src","main", "resources", "files", "xml", "shops.xml");
    public static final Path CUSTOMERS_FILE_PATH =
            Path.of("src","main", "resources", "files", "json", "customers.json");
    public static final Path LAPTOPS_FILE_PATH =
            Path.of("src","main", "resources", "files", "json", "laptops.json");
}
