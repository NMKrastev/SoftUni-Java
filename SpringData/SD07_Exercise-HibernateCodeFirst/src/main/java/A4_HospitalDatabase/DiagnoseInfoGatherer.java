package A4_HospitalDatabase;

import java.util.Scanner;

public class DiagnoseInfoGatherer {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getName() {

        String name = null;

        while (name == null) {

            System.out.print("Please, enter diagnose name: ");
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                name = null;
            }
        }

        return name;
    }

    public static String getComment() {

        String comment = null;

        while (comment == null) {

            System.out.print("Please, enter diagnose comment: ");
            comment = scanner.nextLine();

            if (comment.trim().isEmpty()) {
                comment = null;
            }
        }

        return comment;
    }
}
