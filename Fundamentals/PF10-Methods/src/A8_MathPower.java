import java.text.DecimalFormat;
import java.util.Scanner;

public class A8_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        double result = getMathPower(number, power);

        System.out.println(new DecimalFormat("0.####").format(result));

    }

    private static double getMathPower(double number, int power) {

        return Math.pow(number, power);
    }
}
/*Create a method that calculates and returns the value of a number raised to a given power.*/