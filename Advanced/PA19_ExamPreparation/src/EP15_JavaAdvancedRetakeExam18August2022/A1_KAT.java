package EP15_JavaAdvancedRetakeExam18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_KAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Long> licensePlates = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Long> cars = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int countDays = 0;
        long registeredCars = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            countDays++;
            long currentPlates = licensePlates.removeFirst();
            long currentCars = cars.removeLast();

            if (currentPlates > currentCars * 2) {
                currentPlates -= currentCars * 2;
                registeredCars += currentCars;
                licensePlates.addLast(currentPlates);
            } else if (currentPlates < currentCars * 2) {
                currentCars -= currentPlates / 2;
                registeredCars += currentPlates / 2;
                cars.addFirst(currentCars);
            } else {
                registeredCars += currentCars;
            }
        }

        System.out.printf("%d cars were registered for %d days!\n" ,registeredCars ,countDays);
        if (!licensePlates.isEmpty()) {
            long sum = 0;
            for (long num : licensePlates) {
                sum += num;
            }
            System.out.printf("%d license plates remain!\n", sum);
        } else if (!cars.isEmpty()){
            long sum = 0;
            for (long num : cars) {
                sum += num;
            }
            System.out.printf("%d cars remain without license plates!\n", sum);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
/*You will be given two sequences of integers – one with license plates and one with cars.
Two license plates are required for each car. Your goal is to find the number of registered cars
and how many days they are installed. If there are cars or license plates that have not been used, you should count them.
The installation starts from the first license plate with the last cars. If, after the end of the day,
license plates remain, they are added at the end of the sequence for a new day. If after the end of the first day
there are cars without license plates, they are added at the beginning of the sequence for a new day.
The procedure is performed until at least one sequence is over.
Input
•	On the first line, you will receive the integers representing the number of license plates, separated by ", ".
•	On the second line, you will receive the integers representing the number of cars, separated by ", ".
Output
•	Print count of registered cars and how many days were needed:
o	“{count of registered cars} cars were registered for {count of days} days!”
•	If there are any remaining license plates:
o	“{count of plates} license plates remain!”
•	If any cars are remaining without license plates:
o	“{count of cars without license plates} cars remain without license plates!”
•	If all cars and license plates were used:
o	"Good job! There is no queue in front of the KAT!"
Constraints
•	License plates will be even numbers.
•	All of the given numbers for license plates will be valid integers in the range [4, 2147483646].
•	All of the given numbers for cars will be valid integers in the range [2, 2147483647].
*/
