package MoreExercises;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double houseHeight = Double.parseDouble(scanner.nextLine());
        double houseWight = Double.parseDouble(scanner.nextLine());
        double roofHeight = Double.parseDouble(scanner.nextLine());

        double frontBackWallsArea = (houseHeight * houseHeight) * 2 - 2.4;
        double sideWallsArea = (houseHeight * houseWight) * 2 - 4.50;
        double totalArea = frontBackWallsArea + sideWallsArea;
        double greenPaintNeeded = totalArea / 3.4;
        double roofSideWallsArea = sideWallsArea + 4.50;
        double roofTriangleArea = 2 * (houseHeight * roofHeight / 2);
        double roofArea = roofTriangleArea + roofSideWallsArea;
        double redPaintNeeded = roofArea / 4.3;

        System.out.printf("%.2f\n%.2f",greenPaintNeeded, redPaintNeeded);

    }
}
