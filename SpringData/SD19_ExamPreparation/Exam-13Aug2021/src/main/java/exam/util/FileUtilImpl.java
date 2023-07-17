package exam.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtilImpl implements FileUtil {


    @Override
    public String readFile(Path path) throws IOException {
        return new String(Files.readAllBytes(path));
    }
}
