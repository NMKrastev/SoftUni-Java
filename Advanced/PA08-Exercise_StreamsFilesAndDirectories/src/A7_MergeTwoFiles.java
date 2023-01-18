import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class A7_MergeTwoFiles {

    public static void main(String[] args) throws IOException {

        PrintWriter print = new PrintWriter("PA08-Exercise_StreamsFilesAndDirectories/resources/merge.txt");
        BufferedReader reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/inputOne.txt"));
        readFiles(reader, print);

        reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/inputTwo.txt"));
        readFiles(reader, print);

        reader.close();
        print.close();
    }

    private static void readFiles(BufferedReader reader, PrintWriter print) throws IOException {
        String line = reader.readLine();

        while (line != null) {
            print.println(line);
            line = reader.readLine();
        }
    }
}
/*Write a program that reads the contents of two text files
("inputOne.txt", "inputTwo.txt" from Resources - Exercises) and merges them into a third one.*/
