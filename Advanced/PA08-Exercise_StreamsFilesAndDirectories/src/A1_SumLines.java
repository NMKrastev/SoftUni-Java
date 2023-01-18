import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A1_SumLines {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get("PA08-Exercise_StreamsFilesAndDirectories/resources/input.txt"));

        String line = reader.readLine();

        while (line != null) {
            long sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }

            System.out.println(sum);
            line = reader.readLine();
        }
    }
}
