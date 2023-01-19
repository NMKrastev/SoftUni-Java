import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A9_CopyPicture {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/Nebula.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/Nebula-copy.jpg");

        byte[] buffer = new byte[1024];

        while (fileInputStream.read(buffer) != -1) {
            fileOutputStream.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
/*Write a program that makes a copy of a .jpg file using FileInputStream, FileOutputStream, and byte[] buffer.
Set the name of the new file as "picture-copy.jpg".*/
