import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int detergents = 750 * Integer.parseInt(scanner.nextLine());
        int count = 0, plate = 0, pot = 0;


        while (detergents >= 0) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            Integer dishes = Integer.parseInt(input);
            count++;

            if (count % 3 == 0) {
                detergents -= dishes * 15;
                pot += dishes;
            } else {
                detergents -= dishes * 5;
                plate += dishes;
            }
        }

        if (detergents >= 0) {
            System.out.printf("Detergent was enough!\n" +
                    "%d dishes and %d pots were washed.\n" +
                    "Leftover detergent %d ml.\n", plate, pot, detergents);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detergents));
        }
    }
}
