package A4_HospitalDatabase;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoGatherer {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String IS_PATIENT_INSURED = "Please, specify if the patient is insured(y/n): ";
    private static final String ENTER_PATIENT_BIRTH_DATE = "Please, enter patient's date of birth(yyyy-mm-dd): ";
    private static final String DOES_PATIENT_HAS_EMAIL = "Does the patient has an email?(y/n): ";
    private static final String ENTER_PATIENT_EMAIL = "Please, enter patient's email: ";
    private static final String ENTER_PATIENT_ADDRESS = "Please, enter patient's address: ";
    private static final String ENTER_LAST_NAME_OF_PATIENT = "Please, enter last name of patient: ";
    private static final String ENTER_FIRST_NAME_OF_PATIENT = "Please, enter first name of patient: ";
    private static final String ENTER_DIAGNOSIS_NAME = "Please, enter diagnosis name: ";
    private static final String ENTER_DIAGNOSIS_COMMENT = "Please, enter diagnosis comment: ";
    private static final String ENTER_MEDICAMENT_NAME = "Please, enter medicament name: ";

    public static Boolean isPatientInsured() {

        Boolean isInsured = null;

        while (isInsured == null) {

            System.out.print(IS_PATIENT_INSURED);
            String yesOrNo = scanner.nextLine();

            if (yesOrNo.equalsIgnoreCase("y")) {
                isInsured = true;
            } else if (yesOrNo.equalsIgnoreCase("n")) {
                isInsured = false;
            }
        }

        return isInsured;
    }

    public static LocalDate gatherPatientDateOfBirth() {

        String birthDate = null;
        String regex = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;
        int year = 0;
        int month = 0;
        int day = 0;

        while (birthDate == null) {

            System.out.print(ENTER_PATIENT_BIRTH_DATE);
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

    public static String gatherPatientEmail() {

        String email = null;

        System.out.print(DOES_PATIENT_HAS_EMAIL);
        String yesOrNo = scanner.nextLine();

        if (yesOrNo.equalsIgnoreCase("y")) {

            while (email == null) {

                System.out.print(ENTER_PATIENT_EMAIL);
                email = scanner.nextLine();

                if (email.trim().isEmpty()) {
                    email = null;
                }
            }
        }

        return email;
    }

    public static String gatherPatientAddress() {

        String address = null;

        while (address == null) {

            System.out.print(ENTER_PATIENT_ADDRESS);
            address = scanner.nextLine();

            if (address.trim().isEmpty()) {
                address = null;
            }
        }

        return address;
    }

    public static String gatherPatientLastName() {

        String lastName = null;

        while (lastName == null) {

            System.out.print(ENTER_LAST_NAME_OF_PATIENT);
            lastName = scanner.nextLine();

            if (lastName.trim().isEmpty()) {
                lastName = null;
            }
        }

        return lastName;
    }

    public static String gatherPatientFirstName() {

        String firstName = null;

        while (firstName == null) {

            System.out.print(ENTER_FIRST_NAME_OF_PATIENT);
            firstName = scanner.nextLine();

            if (firstName.trim().isEmpty()) {
                firstName = null;
            }
        }

        return firstName;
    }

    public static String gatherDiagnosisName() {

        String name = null;

        while (name == null) {

            System.out.print(ENTER_DIAGNOSIS_NAME);
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                name = null;
            }
        }

        return name;
    }

    public static String gatherDiagnosisComment() {

        String comment = null;

        while (comment == null) {

            System.out.print(ENTER_DIAGNOSIS_COMMENT);
            comment = scanner.nextLine();

            if (comment.trim().isEmpty()) {
                comment = null;
            }
        }

        return comment;
    }
    
    public static String gatherMedicamentName() {

        String name = null;

        while (name == null) {

            System.out.print(ENTER_MEDICAMENT_NAME);
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                name = null;
            }
        }

        return name;
    }
}
