import java.util.Scanner;

public class A8_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());
        double maxRadius = Double.MIN_VALUE;
        String winKeg = "";

        for (int i = 0; i < n; i++) {

            String model = scanner.nextLine();
            double currentRadius = Double.parseDouble(scanner.nextLine());
            int currentHeight = Integer.parseInt(scanner.nextLine());

            double radius = Math.PI * (currentRadius * currentRadius) * currentHeight;

            if (radius > maxRadius) {

                maxRadius = radius;
                winKeg = model;

            }
        }

        System.out.println(winKeg);
    }
}
/*Write a program that calculates the volume of n beer kegs. You will
receive in total 3 * n lines. Every three lines will hold information
for a single keg. First up is the model of the keg, after that is the
radius of the keg, and lastly is the height of the keg.
Calculate the volume using the following formula: π * r^2 * h.
In the end, print the model of the biggest keg.
Input:
You will receive 3 * n lines. Each group of lines will be on a new line:
· First – model – string
· Second –radius – floating-point number
· Third – height – integer number
Output:
Print the model of the biggest keg.
Constraints:
· n will be in the interval [1…10].
· The radius will be a floating-point number in the interval [1…3.402823E+38].
· The height will be an integer in the interval [1…2147483647]*/
