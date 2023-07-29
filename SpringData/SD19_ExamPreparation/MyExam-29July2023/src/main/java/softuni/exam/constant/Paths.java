package softuni.exam.constant;

import java.nio.file.Path;

public enum Paths {

    ;

    public static Path CONSTELLATIONS_FILE =
            Path.of("src", "main", "resources", "files", "json", "constellations.json");
    public static Path STARS_FILE =
            Path.of("src", "main", "resources", "files", "json", "stars.json");
    public static Path ASTRONOMERS_FILE =
            Path.of("src", "main", "resources", "files", "xml", "astronomers.xml");
}
