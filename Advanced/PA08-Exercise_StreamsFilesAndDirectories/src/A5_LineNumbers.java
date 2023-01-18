import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class A5_LineNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/inputLineNumbers.txt"));
        PrintWriter print = new PrintWriter("PA08-Exercise_StreamsFilesAndDirectories/resources/output2.txt");

        int lineCount = 1;
        String line = reader.readLine();
        while (line != null) {
            line = String.format("%d. %s", lineCount, line);
            print.println(line);

            line = reader.readLine();
            lineCount++;
        }

        reader.close();
        print.close();
    }
}
/*Write a program that reads a text file ("inputLineNumbers.txt" from the Resources - Exercises)
and inserts line numbers in front of each of its lines.
The result should be written to another text file – "output.txt". */
