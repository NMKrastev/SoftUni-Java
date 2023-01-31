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
/*There is something really annoying in the C# - language. It is called a Tuple. It is a class that contains two objects.
The first one is item1, and the second one is item2. It is kind of like a Map.Entry except - it simply has items that
are neither key nor value. The annoyance comes from the fact that you have no idea what these objects hold.
The class name is telling you nothing, the methods which it has – too. So let's say we could try to implement it in Java,
just for practicing generics.
Create a class Tuple, which is holding two objects. As we said, the first one will be an item1, and the second one -
an item2. The tricky part here is to make the class hold generics. This means that when you create a new object of class -
Tuple, there should be a way to explicitly specify both the items type separately.
Input
The input consists of three lines:
•	The first one is holding a person's name and an address. They are separated by space. Your task is to collect them
in the tuple and print them on the console. Format:
"{first name} {last name} {address}"
•	The second line holds a person's name and the amount of beer he can drink. Format:
"{name} {liters of beer}"
•	The last line will hold an Integer and a Double. Format:
"{Integer} {Double}"
Output
•	Print the tuples items in format: "{item1} -> {item2}"
Constraints
Use the good practices we have learned. Create the class and make it have getters and setters for its class variables.
The input will be valid, no need to check it explicitly!
*/
