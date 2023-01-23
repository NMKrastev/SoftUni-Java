package A3_SpeedRacing;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        while (num-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostForKm = Double.parseDouble(data[2]);
            Car car = new Car(model, fuelAmount, fuelCostForKm);
            carsMap.put(model, car);
        }

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String model = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);

            Car carToDrive = carsMap.get(model);
            carToDrive.drive(distance);
        }

        carsMap.values().forEach(System.out::println);
    }
}
/*Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars.
Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer, and distance
traveled. A Car Model is unique - there will never be 2 cars with the same model.
 On the first line of the input, you will receive a number N - the number of cars you need to track,
 on each of the next N lines you will receive information for a car in the following format
 "{Model} {FuelAmount} {FuelCostFor1km}", all cars start at 0 kilometers traveled.
After the N lines, until the command "End" is received, you will receive commands in the following format
"Drive {CarModel} {amountOfKm}", implement a method in the Car class to calculate whether a car can move that distance
or not. If yes, the car fuel amount should be reduced by the amount of used fuel, and its distance traveled should be
increased by the amount of kilometers traveled, otherwise, the car should not move
(Its fuel amount and distance traveled should stay the same) and you should print on the console "Insufficient fuel
for the drive". After the "End" command is received, print each car in order of appearing in input, and its current
fuel amount and distance traveled in the format "{Model} {fuelAmount} {distanceTraveled}", where the fuel amount
should be printed to two decimal places after the separator.
*/