package A4_HospitalDatabase;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientInfoGatherer {

    private static final Scanner scanner = new Scanner(System.in);

    public static Boolean isInsured() {

        Boolean isInsured = null;

        while (isInsured == null) {

            System.out.print("Please, specify if the patient is insured(y/n): ");
            String yesOrNo = scanner.nextLine();

            if (yesOrNo.equalsIgnoreCase("y")) {
                isInsured = true;
            } else if (yesOrNo.equalsIgnoreCase("n")) {
                isInsured = false;
            }
        }

        return isInsured;
    }

    public static LocalDate getDateOfBirth() {

        String birthDate = null;
        String regex = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;
        int year = 0;
        int month = 0;
        int day = 0;

        while (birthDate == null) {

            System.out.print("Please, enter patient's date of birth(yyyy-mm-dd): ");
            birthDate = scanner.nextLine();

            if (birthDate.trim().isEmpty()) {
                birthDate = null;
            } else {
                matcher = pattern.matcher(birthDate);
                if (!matcher.find()) {
                    birthDate = null;
                } else {
                    year = Integer.parseInt(matcher.group(1));
                    month = Integer.parseInt(matcher.group(2));
                    day = Integer.parseInt(matcher.group(3));
                }
            }
        }

        return LocalDate.of(year, month, day);
    }

    public static String getEmail() {

        String email = null;

        System.out.print("Does the patient has an email?(y/n): ");
        String yesOrNo = scanner.nextLine();

        if (yesOrNo.equalsIgnoreCase("y")) {

            while (email == null) {

                System.out.print("Please, enter patient's email: ");
                email = scanner.nextLine();

                if (email.trim().isEmpty()) {
                    email = null;
                }
            }
        }

        return email;
    }

    public static String getAddress() {

        String address = null;

        while (address == null) {

            System.out.print("Please, enter patient's address: ");
            address = scanner.nextLine();

            if (address.trim().isEmpty()) {
                address = null;
            }
        }

        return address;
    }

    public static String getLastName() {

        String lastName = null;

        while (lastName == null) {

            System.out.print("Please, enter last name of patient: ");
            lastName = scanner.nextLine();

            if (lastName.trim().isEmpty()) {
                lastName = null;
            }
        }

        return lastName;
    }

    public static String getFirstName() {

        String firstName = null;

        while (firstName == null) {

            System.out.print("Please, enter first name of patient: ");
            firstName = scanner.nextLine();

            if (firstName.trim().isEmpty()) {
                firstName = null;
            }
        }

        return firstName;
    }
}
