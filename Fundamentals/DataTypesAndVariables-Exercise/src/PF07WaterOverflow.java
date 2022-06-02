import java.util.Scanner;

public class PF07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        short tankCapacity = 0;
        //boolean isCapacityReached = false;

        for (int i = 0; i < n; i++) {
            short liters = Short.parseShort(scanner.nextLine());
            tankCapacity += liters;

            if (liters > 255 && i == 0) {
                tankCapacity = 0;
                System.out.println("Insufficient capacity!");
            } else if (tankCapacity > 255) {
                System.out.println("Insufficient capacity!");
                tankCapacity -= liters;
            }
        }
        System.out.println(tankCapacity);
    }
}

/*You have a water tank with a capacity of 255 liters.
On the next n lines, you will receive liters of water, which you have to pour into your tank.
If the capacity is not enough, print "" and continue reading the next line.
On the last line, print the liters in the tank.
Input
The input will be on two lines:
•	On the first line, you will receive n – the number of lines, which will follow
•	On the next n lines – you receive quantities of water, which you have to pour into the tank
Output
Every time you do not have enough capacity in the tank to pour the given liters, print:
"Insufficient capacity!".
On the last line, print only the liters in the tank.
Constraints
•	n will be in the interval [1…20].
•	liters will be in the interval [1…1000].
*/