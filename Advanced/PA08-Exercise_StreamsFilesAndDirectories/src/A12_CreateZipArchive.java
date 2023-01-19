import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class A12_CreateZipArchive {

    public static void main(String[] args) throws IOException {

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/files.zip"));
        FileInputStream fileInputStream = new FileInputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/output.txt");
        ZipEntry zipEntry = new ZipEntry("PA08-Exercise_StreamsFilesAndDirectories/resources/output.txt");

        addToZip(zipOutputStream, fileInputStream, zipEntry);

        fileInputStream = new FileInputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/output2.txt");
        zipEntry = new ZipEntry("PA08-Exercise_StreamsFilesAndDirectories/resources/output2.txt");
        addToZip(zipOutputStream, fileInputStream, zipEntry);

        fileInputStream = new FileInputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/results.txt");
        zipEntry = new ZipEntry("PA08-Exercise_StreamsFilesAndDirectories/resources/results.txt");
        addToZip(zipOutputStream, fileInputStream, zipEntry);

        fileInputStream.close();
        zipOutputStream.close();
    }

    private static void addToZip(ZipOutputStream zipOutputStream, FileInputStream fileInputStream, ZipEntry zipEntry) throws IOException {

        zipOutputStream.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes)) >= 0) {
            zipOutputStream.write(bytes, 0, length);
        }
    }
}
/*Write a program that reads three .txt files and creates a zip archive named "files.zip".
Use FileOutputStream, ZipOutputStream, and FileInputStream.*/
