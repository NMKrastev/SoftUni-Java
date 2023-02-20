package A1_ClassBoxDataValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        Box box;
        try {
            box = new Box(length, width, height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.printf("Surface Area - %.2f\n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f\n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f\n", box.calculateVolume());
    }
}
/*You are given a geometric figure Box with fields length, width, and height.
Model a class Box that can be instantiated by the same three parameters.
Expose to the outside world only methods for its surface area, lateral surface area, and its volume
(formulas: http://www.mathwords.com/r/rectangular_parallelepiped.htm).
On the first three lines, you will get the length, width, and height. On the next three lines print the surface area,
lateral surface area, and the volume of the box.
A box’s side should not be zero or a negative number. Add data validation for each parameter given to the constructor.
Make a private setter that performs data validation internally.
Box
-	length: double
-	width:  double
-	height:  double
+ 	Box (double length, double width, double height)
-	setLength(double): void
-	setWidth(double): void
-	setHeight(double): void
+	calculateSurfaceArea (): double
+	calculateLateralSurfaceArea (): double
+	calculateVolume (): double
*/