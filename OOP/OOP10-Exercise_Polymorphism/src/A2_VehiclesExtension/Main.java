package A2_VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, VehicleImpl> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));
        vehicleMap.put("Bus", getVehicle(scanner));

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];
            double argument = Double.parseDouble(commandParts[2]);

            switch (command) {
                case "Drive":
                    vehicleMap.get(vehicleType).setIsWithPassengers(true);
                    try {
                        vehicleMap.get(vehicleType).drive(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    vehicleMap.get(vehicleType).setIsWithPassengers(false);
                    try {
                        vehicleMap.get(vehicleType).drive(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Refuel":
                    try {
                        vehicleMap.get(vehicleType).refuel(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static VehicleImpl getVehicle(Scanner scanner) {

        String[] vehicleInput = scanner.nextLine().split("\\s+");

        String vehicleType = vehicleInput[0];
        double fuelQuantity = Double.parseDouble(vehicleInput[1]);
        double litersPerKm = Double.parseDouble(vehicleInput[2]);
        double tankCapacity = Double.parseDouble(vehicleInput[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, litersPerKm, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, litersPerKm, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, litersPerKm, tankCapacity);
            default:
                throw new IllegalArgumentException("Invalid vehicle type!");
        }
    }
}
/*Use your solution to the previous task for a starting point and add more functionality.
Add new vehicle – Bus. Now every vehicle has tank capacity and fuel quantity cannot fall (set) below 0
(If fuel quantity becomes less than 0 print on the console "Fuel must be a positive number").
The vehicles cannot be filled with fuel more than their tank capacity. If you try to put more fuel in the tank
than the available space, print on the console "Cannot fit fuel in tank" and do not add any fuel to the vehicle's tank.
Add new command for the bus. The bus can drive with or without people. If the bus is driving with people,
the air-conditioner is turned on and its fuel consumption per kilometer is increased by 1.4 liters.
If there are no people on the bus when driving the air-conditioner is turned off and does not increase the fuel consumption.
Input
•	On the first three lines you will receive information about the vehicles in the format:
Vehicle {initial fuel quantity} {liters per km} {tank capacity}
•	On the fourth line - a number of commands N will be given on the next N lines.
•	On the next N lines – commands in format:
o	Drive Car {distance}
o	Drive Truck {distance}
o	Drive Bus {distance}
o	DriveEmpty Bus {distance}
o	Refuel Car {liters}
o	Refuel Truck {liters}
o	Refuel Bus {liters}
Output
•	After each Drive command print whether the Car/Truck was able to travel a given distance
in format if it’s successful: "Car/Truck/Bus travelled {distance} km".
•	If the command is invalid - do nothing.
•	Or if it is not: "Car/Truck/Bus needs refueling".
•	If given fuel is ≤ 0 print: "Fuel must be a positive number".
•	If given fuel cannot fit in car or bus tank print: "Cannot fit fuel in tank".
•	Finally, print the remaining fuel for a car, truck and bus rounded 2 digits after a floating point in the format:
"Car: {liters}
Truck: {liters}
Bus: {liters}"
*/
