import java.util.Scanner;

public class A7_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte num = Byte.parseByte(scanner.nextLine());
        short totalLiters = 0;

        for (int i = 0; i < num; i++) {

            short liters = Short.parseShort(scanner.nextLine());

                totalLiters += liters;

            if (totalLiters > 255) {

                totalLiters -= liters;
                System.out.println("Insufficient capacity!");

            }
        }

        System.out.println(totalLiters);
    }
}
/*You have a water tank with a capacity of 255 liters. On the
next n lines, you will receive liters of water, which you must
pour into your tank. If the capacity is not enough, print
"Insufficient capacity!" and continue reading the next line.
On the last line, print the liters in the tank.
Input:
The input will be on two lines:
· On the first line, you will receive n – the number of lines, which will follow
· On the next n lines – you receive quantities of water, which you have to pour into the tank
Output:
Every time you do not have enough capacity in the tank to pour the given liters, print:
"Insufficient capacity!".
On the last line, print only the liters in the tank.
Constraints:
· n will be in the interval [1…20].
· liters will be in the interval [1…1000].*/