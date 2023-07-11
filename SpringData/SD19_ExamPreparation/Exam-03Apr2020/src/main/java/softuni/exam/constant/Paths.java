package softuni.exam.constant;

import java.nio.file.Path;

public enum Paths {

    ;

    public static final Path TOWNS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "json", "towns.json");
    public static final Path PASSENGERS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "json", "passengers.json");
    public static final Path PLANES_FILE_PATH =
            Path.of("src", "main", "resources", "files", "xml", "planes.xml");
    public static final Path TICKETS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "xml", "tickets.xml");
}

