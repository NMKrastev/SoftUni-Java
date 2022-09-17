import java.util.Scanner;

public class A5_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        StringBuffer sbr = new StringBuffer(user);
        String password = String.valueOf(sbr.reverse());
        int count = 1;
        boolean isLogged = false;

        while (!isLogged) {

            String pass = scanner.nextLine();

            if (pass.equals(password)) {
                isLogged = true;
                System.out.printf("User %s logged in.", user);
            } else {
                if (count >= 4) {
                    System.out.printf("User %s blocked!", user);
                    break;
                } else {
                    System.out.println("Incorrect password. Try again.");
                    count++;
                }
            }
        }
    }
}
/*You will be given a string representing a username. The password
will be that username reversed. Until you receive the correct
password, print on the console "Incorrect password. Try again.".
When you receive the correct password, print "User {username}
logged in." However, on the fourth try, if the password is still
not correct, print "User {username} blocked!" and end the program.*/