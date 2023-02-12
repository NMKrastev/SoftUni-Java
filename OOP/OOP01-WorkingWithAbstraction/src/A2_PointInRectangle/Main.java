package A2_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int countPoints = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countPoints; i++) {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = pointCoordinates[0];
            int y = pointCoordinates[1];

            Point searchedPoint = new Point(x, y);
            System.out.println(rectangle.contains(searchedPoint));
        }
    }
}
/*Create a class Point and a class Rectangle. The Point should hold coordinates X and Y
and the Rectangle should hold 2 Points – its bottom left and top right corners. In the Rectangle class,
you should implement a contains(Point point) method that returns true or false, based on whether the Point given
as an attribute is inside or outside of the Rectangle object. Points on the side of a Square are considered inside.
Input
•	On the first line read the coordinates of the bottom left and top right corner of the Rectangle in the format:
"{bottomLeftX} {bottomLeftY} {topRightX} {topRightY}".
•	On the second line, read an integer N and on the next N lines, read the coordinates of points.
Output
•	For each point, print out the result of the Contains() method.
*/
