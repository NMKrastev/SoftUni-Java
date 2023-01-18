import java.io.*;

public class A3_ALLCAPITALS {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("PA08-Exercise_StreamsFilesAndDirectories/resources/input.txt"));
        PrintWriter print = new PrintWriter("PA08-Exercise_StreamsFilesAndDirectories/resources/output.txt");

        String line = reader.readLine();

        while (line != null) {
            print.println(line.toUpperCase());
            line = reader.readLine();
        }

        reader.close();
        print.close();
    }
}
/*Write a program that reads a text file ("input.txt" from the Resources - Exercises)
and changes the casing of all letters to the upper. Write the output to another file ("output.txt").*/
