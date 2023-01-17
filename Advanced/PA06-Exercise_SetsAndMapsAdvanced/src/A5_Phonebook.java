import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A5_Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("search")) {
                String name = input.split("-")[0];
                String phoneNum = input.split("-")[1];
                phoneBook.put(name, phoneNum);
        }
        while (!(input = scanner.nextLine()).equals("stop")) {
            String name = input;
            if (phoneBook.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
        }
    }
}
/*Write a program that receives some info from the console about people and their phone numbers.
You are free to choose how the data is entered. Each entry should have just one name and one number (both of them strings).
If you receive a name that already exists in the phonebook, simply update its number.
After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a
search of contact by name and print her details in the format "{name} -> {number}".
In case the contact isn't found, print "Contact {name} does not exist.".
*/
