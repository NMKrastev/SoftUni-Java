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
