import java.io.FileInputStream;
import java.io.IOException;

public class A1_ReadFile {

    public static void main(String[] args) {

        String path = "PA07-StreamsFilesAndDirectories/resources/input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int bytes = fileInputStream.read();

            while (bytes != -1) {

                System.out.print(Integer.toBinaryString(bytes) + " ");
                bytes = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
/*You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes
(the binary representation of the ASCII code for each character) separated by a single comma. */
