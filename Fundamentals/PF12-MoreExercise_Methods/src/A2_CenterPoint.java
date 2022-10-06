import java.util.Scanner;

public class A2_CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        if (getDistance(x1, y1) <= (getDistance(x2, y2))) {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        } else {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        }

    }

    private static double getDistance(double x, double y) {

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
/*You are given the coordinates of two points on a Cartesian coordinate system - X1, Y1, X2, and Y2.
Create a method that prints the point that is closest to the center of the coordinate system (0, 0)
in the format (X, Y). If the points are at the same distance from the center, print only the first one.*/