package softuni.exam.constant;

import java.nio.file.Path;

public enum Paths {

    ;

    public static final Path CARS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "json", "cars.json");
    public static final Path PICTURES_FILE_PATH =
            Path.of("src", "main", "resources", "files", "json", "pictures.json");
    public static final Path SELLERS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "xml", "sellers.xml");
    public static final Path OFFERS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "xml", "offers.xml");
}
