import java.util.Scanner;

public class PF11RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine());

        System.out.printf("Pyramid Volume: %.2f", (length * width * height) / 3);

    }
}
/*You are given a working code that finds the volume of a pyramid. However, you should
consider that the variables exceed their optimum span and have improper naming.
Also, search for variables that have multiple purposes.*/