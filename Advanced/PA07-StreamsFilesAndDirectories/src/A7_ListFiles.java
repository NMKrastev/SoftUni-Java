import java.io.File;

public class A7_ListFiles {

    public static void main(String[] args) {

        File file = new File("PA07-StreamsFilesAndDirectories/resources/Files-and-Streams/");

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File current : files) {
                if(!current.isDirectory()) {
                    System.out.printf("%s: [%s]\n", current.getName(), current.length());
                }
            }
        }
    }
}
/*You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes)
of all files that are placed directly in it (do not include files in nested folders). */
