import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A8_GetFolderSize {

    public static void main(String[] args) throws IOException {

        Path folder = Paths.get("PA08-Exercise_StreamsFilesAndDirectories/resources/Exercises Resources");
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();

        System.out.printf("Folder size: %d", size);
    }
}
/*Write a program that traverses a folder and calculates its size in bytes. Use Folder Exercises Resources in Resources.*/
