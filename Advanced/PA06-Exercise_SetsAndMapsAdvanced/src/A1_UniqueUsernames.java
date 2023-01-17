import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A1_UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            String user = scanner.nextLine();
            usernames.add(user);
        }

        usernames.forEach(name -> System.out.printf("%s\n", name));
    }
}
/*Write a simple program that reads a sequence of usernames from the console and keeps a collection with
only the unique ones. Print the collection on the console in order of insertion:*/
