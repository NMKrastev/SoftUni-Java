import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A3_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, Integer>> carsInfoMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        addCarsInfo(scanner, carsInfoMap, n);

        String command;

        while (!(command = scanner.nextLine()).equals("Stop")) {

            if (command.contains("Drive")) {
                driveCar(carsInfoMap, command);
            } else if (command.contains("Refuel")) {
                refuelCar(carsInfoMap, command);
            } else if (command.contains("Revert")) {
                revertMileageOfCar(carsInfoMap, command);
            }
        }
        printResult(carsInfoMap);
    }

    private static void printResult(Map<String, Map<Integer, Integer>> carsInfoMap) {

        carsInfoMap.forEach((key, value) ->
                value.forEach((mileage, fuel) ->
                        System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", key, mileage, fuel)));
    }

    private static void revertMileageOfCar(Map<String, Map<Integer, Integer>> carsInfoMap, String command) {

        String car = command.split("\\s+:\\s+".trim())[1];
        int mileageToRevert = Integer.parseInt(command.split("\\s+:\\s+".trim())[2]);
        for (Map.Entry<Integer, Integer> entry : carsInfoMap.get(car).entrySet()) {
            int currentMileage = entry.getKey();
            int currentFuel = entry.getValue();
            if (currentMileage - mileageToRevert < 10000) {
                carsInfoMap.get(car).clear();
                carsInfoMap.get(car).put(10000, currentFuel);
                break;
            } else {
                carsInfoMap.get(car).clear();
                carsInfoMap.get(car).put(currentMileage - mileageToRevert, currentFuel);
                System.out.printf("%s mileage decreased by %d kilometers\n", car, mileageToRevert);
                break;
            }
        }
    }

    private static void refuelCar(Map<String, Map<Integer, Integer>> carsInfoMap, String command) {

        String car = command.split("\\s+:\\s+".trim())[1];
        int fuel = Integer.parseInt(command.split("\\s+:\\s+".trim())[2]);
        for (Map.Entry<Integer, Integer> entry : carsInfoMap.get(car).entrySet()) {
            int currentFuel = entry.getValue();
            if (currentFuel + fuel > 75) {
                entry.setValue(75);
                System.out.printf("%s refueled with %d liters\n", car, 75 - currentFuel);
                break;
            } else {
                entry.setValue(currentFuel + fuel);
                System.out.printf("%s refueled with %d liters\n", car, fuel);
                break;
            }
        }
    }

    private static void driveCar(Map<String, Map<Integer, Integer>> carsInfoMap, String command) {

        String car = command.split("\\s+:\\s+".trim())[1];
        int distanceToDrive = Integer.parseInt(command.split("\\s+:\\s+".trim())[2]);
        int fuelNeeded = Integer.parseInt(command.split("\\s+:\\s+".trim())[3]);
        for (Map.Entry<Integer, Integer> entry : carsInfoMap.get(car).entrySet()) {
            int currentMileage = entry.getKey();
            int fuelInTheTank = entry.getValue();
            if (fuelInTheTank >= fuelNeeded) {
                carsInfoMap.get(car).clear();
                carsInfoMap.get(car).put(currentMileage + distanceToDrive, fuelInTheTank -= fuelNeeded);
                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",
                        car, distanceToDrive, fuelNeeded);

                if (currentMileage + distanceToDrive >= 100000) {
                    carsInfoMap.remove(car);
                    System.out.printf("Time to sell the %s!\n", car);
                }
                break;
            } else {
                System.out.println("Not enough fuel to make that ride");
                break;
            }
        }
    }

    private static Map<String, Map<Integer, Integer>> addCarsInfo(Scanner scanner, Map<String, Map<Integer, Integer>> carsInfoMap, int n) {

        String input;
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            String car = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);
            carsInfoMap.putIfAbsent(car, new LinkedHashMap<>());
            carsInfoMap.get(car).put(mileage, fuel);
        }

        return carsInfoMap;
    }
}
/*On the first line of the standard input, you will receive an integer n – the number of cars that you can obtain.
On the next n lines, the cars themselves will follow with their mileage and fuel available, separated by "|" in the following format:
"{car}|{mileage}|{fuel}"
Then, you will be receiving different commands, each on a new line, separated by " : ", until the "Stop" command is given:
•	"Drive : {car} : {distance} : {fuel}":
o	You need to drive the given distance, and you will need the given fuel to do that. If the car doesn't have enough
fuel, print: "Not enough fuel to make that ride"
o	If the car has the required fuel available in the tank, increase its mileage with the given distance, decrease its
fuel with the given fuel, and print:
"{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
o	You like driving new cars only, so if a car's mileage reaches 100 000 km, remove it from the collection(s) and print:
"Time to sell the {car}!"
•	"Refuel : {car} : {fuel}":
o	Refill the tank of your car.
o	Each tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is more than you can fit in the
tank, take only what is required to fill it up.
o	Print a message in the following format: "{car} refueled with {fuel} liters"
•	"Revert : {car} : {kilometers}":
o	Decrease the mileage of the given car with the given kilometers and print the kilometers you have decreased it
with in the following format:
"{car} mileage decreased by {amount reverted} kilometers"
o	If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km and
DO NOT print anything.
Upon receiving the "Stop" command, you need to print all cars in your possession in the following format:
"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
Input/Constraints
•	The mileage and fuel of the cars will be valid, 32-bit integers, and will never be negative.
•	The fuel and distance amounts in the commands will never be negative.
•	The car names in the commands will always be valid cars in your possession.
Output
•	All the output messages with the appropriate formats are described in the problem description.
*/