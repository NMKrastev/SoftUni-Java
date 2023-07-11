package softuni.exam.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtilImpl implements FileUtil {

    @Override
    public String readFile(Path filePath) throws IOException {

        return new String(Files.readAllBytes(filePath));
    }
}
