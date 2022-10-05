import java.util.Scanner;

public class A4_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!checkPasswordLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkForLettersAndDigitsOnly(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!checkIfContainsDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (checkPasswordLength(password) && checkForLettersAndDigitsOnly(password) && checkIfContainsDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean checkPasswordLength(String password) {

        String passwordLength = password;

        if (passwordLength.length() >= 6 && passwordLength.length() <= 10) {
            return true;
        }

        return false;
    }

    private static boolean checkForLettersAndDigitsOnly(String password) {

        char[] array = password.toCharArray();

        for (int i = 0; i < array.length; i++) {

            if (!Character.isLetterOrDigit(array[i])) {

                return false;

            }
        }
        return true;
    }

    private static boolean checkIfContainsDigits(String password) {

        char[] array = password.toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {

            if (Character.isDigit(array[i])) {
                count++;

                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*Write a program that checks if a given password is valid. Password rules are:
•	6 – 10 characters (inclusive);
•	Consists only of letters and digits;
•	Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule, print a message:
•	"Password must be between 6 and 10 characters";
•	"Password must consist only of letters and digits";
•	"Password must have at least 2 digits".
Write a method for each rule.
*/
/*if (checkPasswordLength(password) && checkIfContainsDigits(password) && checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password is valid");
        } else if (!checkPasswordLength(password) && checkIfContainsDigits(password) && checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        } else if (!checkPasswordLength(password) && !checkIfContainsDigits(password) && checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            System.out.println("Password must have at least 2 digits");
        } else if (!checkPasswordLength(password) && !checkIfContainsDigits(password) && !checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            System.out.println("Password must have at least 2 digits");
            System.out.println("Password must consist only of letters and digits");
        } else if (checkPasswordLength(password) && !checkIfContainsDigits(password) && !checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must consist only of letters and digits");
            System.out.println("Password must have at least 2 digits");
        } else if (checkPasswordLength(password) && checkIfContainsDigits(password) && !checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must consist only of letters and digits");
        } else if (!checkPasswordLength(password) && checkIfContainsDigits(password) && !checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            System.out.println("Password must consist only of letters and digits");
        } else if (checkPasswordLength(password) && !checkIfContainsDigits(password) && checkForCharsAndDigitsOnly(password)) {
            System.out.println("Password must have at least 2 digits");
        }*/