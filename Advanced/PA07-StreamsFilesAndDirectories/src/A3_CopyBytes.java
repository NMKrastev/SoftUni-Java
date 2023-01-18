import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class A3_CopyBytes {

    public static void main(String[] args) throws IOException {

        Set<Integer> delimetersSet = Set.of(10, 32);
        FileInputStream fileInputStream = new FileInputStream("PA07-StreamsFilesAndDirectories/resources/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("PA07-StreamsFilesAndDirectories/resources/03.CopyBytesOutput.txt");
        int bytes = fileInputStream.read();

        while (bytes != -1) {
            boolean isDelimeters = delimetersSet.contains(bytes);

            if (isDelimeters) {
                fileOutputStream.write(bytes);
            } else {
                String digits = String.valueOf(bytes);
                for (int i = 0; i < digits.length(); i++) {
                    fileOutputStream.write(digits.charAt(i));
                }
            }

            bytes = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
/*Read the file named "input.txt" and write to another file every character's ASCII representation.
Write every space or new line as it is, e.g., a space or a new line.
*/
