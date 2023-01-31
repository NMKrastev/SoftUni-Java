package A11_Threeuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", input[0], input[1]);
        String hood = input[2];
        String city = input[3];
        Threeuple <String, String, String> firstTuple = new Threeuple<>(name, hood, city);
        System.out.println(firstTuple);

        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        String drunkOrNot = input[2];
        Threeuple<String, Integer, Boolean> secondTuple = new Threeuple<>(firstName, litersOfBeer, drunkOrNot.equals("drunk"));
        System.out.println(secondTuple);

        input = scanner.nextLine().split("\\s+");
        firstName = input[0];
        double doubleNumber = Double.parseDouble(input[1]);
        String bankName = input[2];
        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(firstName, doubleNumber, bankName);
        System.out.println(thirdTuple);
    }
}
/*Now you are aware of a Class, which is probably a bad practice to use. Anyway, it is a nice example of using generics.
Our next task is to create another Tuple. This time, our task is harder.
Create a Class Threeuple. Its name tells us that it will no longer hold just a pair of objects.
The task is simple, our Threeuple should hold three objects. Make it have getters and setters.
You can even extend the previous class.
Input
The input consists of three lines:
•	The first one holds a name, an address, and a town. Format of the input:
"{first name} {last name} {address} {town}"
•	The second line holds a name, beer liters, and a Boolean variable - drunk or not. Format:
"{name} {liters of beer} {drunk or not}"
•	The last line will hold a name, a bank balance (double), and a bank name. Format:
"{name} {account balance} {bank name}"
Output
•	Print the Threeuples objects in format: "{firstElement} -> {secondElement} -> {thirdElement}"
*/
