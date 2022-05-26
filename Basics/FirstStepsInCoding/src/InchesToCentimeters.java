import java.util.Scanner;

public class InchesToCentimeters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inches = ");
        double inches = scanner.nextDouble();
        double centimeters = inches * 2.54;

        System.out.print("Centimeters = ");
        System.out.println(centimeters);

    }
}