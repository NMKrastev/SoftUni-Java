import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class A1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLotSet = new LinkedHashSet<>();
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

           if (input.contains("IN")) {
               parkingLotSet.add(input.split(",\\s+")[1]);
           } else {
               parkingLotSet.remove(input.split(",\\s+")[1]);
           }
        }

        if (!parkingLotSet.isEmpty()) {
            parkingLotSet.forEach(System.out::println);
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
/*Write a program that:
o	Records car numbers for every car that enters the parking lot.
o	Removes car number when the car is out.
When the parking lot is empty, print "Parking Lot is Empty".
Input
The input will be a string in the format "{direction, carNumber}".
The input ends with the string "END".
Output
Print the output with all car numbers which are in the parking lot.
*/
