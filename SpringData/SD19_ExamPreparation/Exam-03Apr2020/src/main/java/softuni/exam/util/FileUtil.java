package softuni.exam.util;

import java.io.IOException;
import java.nio.file.Path;

public interface FileUtil {

    String readFile(Path filePath) throws IOException;
}
