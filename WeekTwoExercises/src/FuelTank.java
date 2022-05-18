import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {

        //String[] fuelTypeList = {"diesel", "gasoline", "gas"};
        Scanner scanner = new Scanner(System.in);
        String fuelType = scanner.nextLine().toLowerCase();
        double liters = Double.parseDouble(scanner.nextLine());



            if (liters >= 25 && fuelType.equals("diesel") || liters >= 25 && fuelType.equals("gasoline") ||
                    liters >= 25 && fuelType.equals("gas")) {
                System.out.printf("You have enough %s.", fuelType);
            } else if (liters < 25 && fuelType.equals("diesel") || liters < 25 && fuelType.equals("gasoline") ||
                    liters < 25 && fuelType.equals("gas")) {
                System.out.printf("Fill your tank with %s!", fuelType);
            } else {
                System.out.println("Invalid fuel!");
            }
    }
}

/*Напишете програма, която познава дали резервоара на едно превозно средство има нужда от презареждане
на горивото или не. От конзолата се четат два реда – текст и реално число, на първия ред се чете типа
на горивото – текст с възможности: "Diesel", "Gasoline" или "Gas", а на втория литрите гориво,
които има в резервоара. Ако литрите гориво са повече или равни на 25,
на конзолата да се отпечата "You have enough {вида на горивото}.",
ако са по-малко от 25, да се отпечата "Fill your tank with {вида на горивото}!".
В случай, че бъде въведено гориво, различно от посоченото, да се отпечата "Invalid fuel!".*/