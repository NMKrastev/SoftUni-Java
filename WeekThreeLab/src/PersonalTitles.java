import java.util.Scanner;

public class PersonalTitles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double age = (double) Math.floor(Double.parseDouble(scanner.nextLine()));
        String gender = scanner.nextLine().toLowerCase();

        if (age < 16) {
            if (gender.equals("m")) {
                System.out.println("Master");
            } else if (gender.equals("f")) {
                System.out.println("Miss");
            }
        } else if (age >= 16) {
            if (gender.equals("m")) {
                System.out.println("Mr.");
            } else if (gender.equals("f")) {
                System.out.println("Ms.");
            }
        }
    }
}