import java.util.Scanner;

public class A6_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double result = getRectArea(width, height);
        System.out.printf("%.0f", result);
    }

    private static double getRectArea(double width, double height) {

        return width * height;
    }
}
