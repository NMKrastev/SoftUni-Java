package com.example.football.util;

import java.io.IOException;
import java.nio.file.Path;

public interface FileUtil {

    String readFile(Path path) throws IOException;
}
