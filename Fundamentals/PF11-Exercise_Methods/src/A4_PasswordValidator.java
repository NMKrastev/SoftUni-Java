import java.util.Scanner;

public class A4_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        checkPasswordLength(password);

    }

    private static void checkPasswordLength(String password) {

        boolean isPassLength = false;
        String[] array = password.split("");

        if (array.length >= 6 && array.length <= 10) {
            isPassLength = true;
        }

        if (isPassLength) {
            checkForLettersAndDigitsOnly(password, isPassLength);
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            checkForLettersAndDigitsOnly(password, isPassLength);
        }

    }
    private static void checkForLettersAndDigitsOnly(String password, boolean isPassLength) {

        boolean isLetterAndDigit = true;
        char[] array = password.toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {

            if (!Character.isLetterOrDigit(array[i])) {
                count++;

                if (count > 0) {
                    isLetterAndDigit = false;
                } else {
                    break;
                }
            }
        }

        if (isPassLength && isLetterAndDigit) {
            checkIfContainsDigits(password, isPassLength, isLetterAndDigit);
        } else if (!isLetterAndDigit) {
            System.out.println("Password must consist only of letters and digits");
            checkIfContainsDigits(password, isPassLength, isLetterAndDigit);
        } else {
            checkIfContainsDigits(password, isPassLength, isLetterAndDigit);
        }
    }

    private static void checkIfContainsDigits(String password, boolean isPassLength, boolean isLetterAndDigit) {

        boolean isDigits = false;
        char[] array = password.toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {

            if (Character.isDigit(array[i])) {
                count++;

                if (count >= 2) {
                    isDigits = true;
                    break;
                }
            }
        }

        if (isPassLength && isLetterAndDigit && isDigits) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password must have at least 2 digits");
        }
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