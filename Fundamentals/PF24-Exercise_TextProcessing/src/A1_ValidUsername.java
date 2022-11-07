import java.util.Scanner;

public class A1_ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String regex = "[A-Za-z0-9_-]{3,16}";
        String[] usernamesArray = scanner.nextLine().split(", ");

        for (String username : usernamesArray) {

            if (username.matches(regex)) {
                System.out.println(username);
            }
        }
        /*List<String> usernamesList = Arrays.stream(scanner.nextLine().split(", "))
                .filter(length -> length.length() >= 3)
                .filter(validCars -> validCars.matches("^[A-Za-z0-9_-]*$"))
                .filter(length -> length.length() <= 16)
                .map(String::toString)
                .collect(Collectors.toList());

        for (String validUsername: usernamesList) {
            System.out.println(validUsername);
        }*/
    }
}
/*Write a program that reads user names on a single line (joined by ", ") and prints all valid usernames.
A valid username is:
•	Has a length between 3 and 16 characters.
•	Contains only letters, numbers, hyphens, and underscores.*/