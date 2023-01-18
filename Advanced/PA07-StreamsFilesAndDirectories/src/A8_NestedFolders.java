import java.io.File;
import java.util.ArrayDeque;

public class A8_NestedFolders {

    public static void main(String[] args) {

        File root = new File("PA07-StreamsFilesAndDirectories/resources/Files-and-Streams/");

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int count = 0;
        //Breadth-First Search (BFS)
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders\n", count);
    }
}
/*You are provided a folder named "Files-and-Streams". Create a program that lists
the names of all directories in it (including all nested directories).
On the last line, print the count of all folders, including the root folder.
*/