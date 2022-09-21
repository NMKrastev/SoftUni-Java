import java.util.Scanner;

public class A1_ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", meters / 1000.0);
    }
}
/*You will be given an integer that will be a distance in meters.
Write a program that converts meters to kilometers formatted to the second decimal point*/