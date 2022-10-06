import java.util.Arrays;
import java.util.Scanner;

public class A3_LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lineOneLength = 0;
        double lineTwoLength = 0;
        boolean[] isCenter = new boolean[2];
        Arrays.fill(isCenter, Boolean.FALSE);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        if ((getDistance(x1, y1)) <= (getDistance(x2, y2))) {
            lineOneLength = getLineLength(x1, x2, y1, y2);
            isCenter[0] = true;
        } else {
            lineOneLength = getLineLength(x2, x1, y2, y1);
        }

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        if ((getDistance(x3, y3)) <= (getDistance(x4, y4))) {
            lineTwoLength = getLineLength(x3, x4, y3, y4);
            isCenter[1] = true;
        } else {
            lineTwoLength = getLineLength(x4, x3, y4, y3);
        }

        if (lineOneLength >= lineTwoLength) {
            if (isCenter[0]) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
            }
        } else {
            if (isCenter[1]) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4, y4, x3, y3);

            }
        }

    }

    private static double getDistance(double x, double y) {

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }


    private static double getLineLength(double x1, double x2, double y1, double y2) {

        double x = (x2 - x1);
        double y = (y2 - y1);
        return Math.abs(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }
}
/*You are given the coordinates of four points in the 2D plane. The first and the second pair of points form two
different lines. Print the longer line in the format "(X1, Y1)(X2, Y2)" starting with the point that is closer
to the center of the coordinate system (0, 0) (You can reuse the method that you wrote for the previous problem).
If the lines are of equal length, print only the first one.*/