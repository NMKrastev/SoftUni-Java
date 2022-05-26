package MoreExercises;

import java.util.Scanner;

public class CircleAreaAndPerimeter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double radius = Double.parseDouble(scanner.nextLine());
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        System.out.printf("%.2f\n%.2f", area, perimeter);
    }
}