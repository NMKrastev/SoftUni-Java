package A4_HospitalDatabase;

import java.util.Scanner;

public class MedicamentInfoGatherer {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getName() {

        String name = null;

        while (name == null) {

            System.out.print("Please, enter medicament name: ");
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                name = null;
            }
        }

        return name;
    }
}
