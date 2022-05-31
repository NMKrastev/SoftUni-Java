import java.util.Scanner;

public class PF05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        StringBuilder pass = new StringBuilder(username);
        pass.reverse();
        String password = String.valueOf(pass);
        String passwordInput = scanner.nextLine();
        int count = 0;
        boolean isCorrect = true;

        while (!password.equals(passwordInput)) {

            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!", username);
                isCorrect = false;
                break;
            }

            System.out.println("Incorrect password. Try again.");

            passwordInput = scanner.nextLine();
        }
        if (isCorrect) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
/*You will be given a string representing a username. The password will be that username reversed.
Until you receive the correct password print on the console "Incorrect password. Try again.". When you receive
the correct password print "User {username} logged in." However on the fourth try if the password is still
not correct print "User {username} blocked!" and end the program.*/