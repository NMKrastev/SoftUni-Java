import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A1_SumLines {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = Files
                .newBufferedReader(Paths.get("PA08-Exercise_StreamsFilesAndDirectories/resources/input.txt"));

        String line = reader.readLine();

        while (line != null) {
            long sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }

            System.out.println(sum);
            line = reader.readLine();
        }

        reader.close();
    }
}
/*Write a program that reads a text file ("input.txt" from the Resources - Exercises)
and prints on the console the sum of the ASCII symbols of each of its lines.
Use BufferedReader in combination with FileReader.
•	Get the ASCII code of each character in the line and add it to the sum
for the current line and print the sum on the console.*/
