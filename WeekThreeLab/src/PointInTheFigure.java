import java.util.Scanner;

public class PointInTheFigure {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        boolean isInside = (x > 0 && x < h * 3) && (y > 0 && y < h)
                || (x > h && x < h * 2) && (y > 0 && y < h * 4);
        boolean isOutside = ((x < 0 || x > h * 3) && y <= h)
                || ((x < h || x > h * 2) && y > h)
                || (y < 0 || y > h * 4);

        if (isInside) {
            System.out.println("inside");
        } else if (isOutside) {
            System.out.println("outside");
        } else {
            System.out.println("border");
        }
    }
}