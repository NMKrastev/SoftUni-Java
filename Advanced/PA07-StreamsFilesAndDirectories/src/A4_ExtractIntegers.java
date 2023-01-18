import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A4_ExtractIntegers {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("PA07-StreamsFilesAndDirectories/resources/input.txt");
        Scanner scanner = new Scanner(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("PA07-StreamsFilesAndDirectories/resources/04.ExtractIntegersOutput.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        printWriter.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
/*Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file.
A valid integer is surrounded by white spaces.*/
