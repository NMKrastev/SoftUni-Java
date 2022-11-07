import java.io.File;
import java.util.Scanner;

public class A3_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String name = path.substring(path.lastIndexOf("\\") + 1);
        String extension = name.split("\\.")[1];
        name = name.substring(0, name.indexOf("."));

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);

    }
}
/*Write a program that reads the path to a file and subtracts the file name and its extension.*/