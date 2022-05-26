import java.util.Scanner;

public class AreaOfFigures {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String figures = scanner.nextLine();

        if (figures.equals("square")) {
            double sideOne = Double.parseDouble(scanner.nextLine());
            sideOne *= sideOne;
            System.out.printf("%.3f", sideOne);
        } else if (figures.equals("rectangle")) {
            double sideOne = Double.parseDouble(scanner.nextLine());
            double sideTwo = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", sideOne * sideTwo);
        } else if (figures.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", (radius * radius) * Math.PI);
        } else if (figures.equals("triangle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", (side * h) / 2 );

        }
    }
}