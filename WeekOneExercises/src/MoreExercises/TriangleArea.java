package MoreExercises;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double area = a * h / 2;
        System.out.printf("%.2f", area);

        /*Напишете програма, която чете от конзолата страна и височина на триъгълник и пресмята неговото лице.
        Използвайте формулата за лице на триъгълник: area = a * h / 2.
         Форматирате изхода до втория знак след десетичната запетая.*/
    }
}
