import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A2_SumBytes {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/input.txt"));
        //BufferedReader reader = Files
        //        .newBufferedReader(Paths.get("PA08-Exercise_StreamsFilesAndDirectories/resources/input.txt"));

        long sum = 0;
        String line = reader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = reader.readLine();
        }

        reader.close();
        System.out.println(sum);
    }
}
/*Write a program that reads a text file ("input.txt" from the Resources - Exercises)
and prints on the console the sum of the ASCII symbols of all characters inside the file.
Use BufferedReader in combination with FileReader.*/
