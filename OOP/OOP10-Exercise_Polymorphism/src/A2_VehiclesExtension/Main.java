package A2_VehiclesExtension;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(carInput[1]);
        double litersPerKm = Double.parseDouble(carInput[2]);
        double tankCapacity = Double.parseDouble(carInput[3]);

        VehicleImpl car = new Car(fuelQuantity, litersPerKm, tankCapacity);

        String[] truckInput = scanner.nextLine().split("\\s+");
        fuelQuantity = Double.parseDouble(truckInput[1]);
        litersPerKm = Double.parseDouble(truckInput[2]);
        tankCapacity = Double.parseDouble(truckInput[3]);

        VehicleImpl truck = new Truck(fuelQuantity, litersPerKm, tankCapacity);

        String[] busInput = scanner.nextLine().split("\\s+");
        fuelQuantity = Double.parseDouble(busInput[1]);
        litersPerKm = Double.parseDouble(busInput[2]);
        tankCapacity = Double.parseDouble(busInput[3]);

        VehicleImpl bus = new Bus(fuelQuantity, litersPerKm, tankCapacity);

        int numOfCommands = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numOfCommands; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];

            if (vehicleType.equals("Car")) {
                if (command.equals("Drive")) {
                    double distance = Double.parseDouble(commandParts[2]);
                    try {
                        car.drive(distance);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (command.equals("Refuel")) {
                    double fuel = Double.parseDouble(commandParts[2]);
                    try {
                        car.refuel(fuel);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (vehicleType.equals("Truck")) {
                if (command.equals("Drive")) {
                    double distance = Double.parseDouble(commandParts[2]);
                    try {
                        truck.drive(distance);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (command.equals("Refuel")) {
                    double fuel = Double.parseDouble(commandParts[2]);
                    try {
                        truck.refuel(fuel);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (vehicleType.equals("Bus")) {

                double distance = Double.parseDouble(commandParts[2]);
                switch (command) {
                    case "Drive":
                        bus.setIsWithPassengers(true);
                        try {
                            bus.drive(distance);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "DriveEmpty":
                        bus.setIsWithPassengers(false);
                        try {
                            bus.drive(distance);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Refuel":
                        double fuel = Double.parseDouble(commandParts[2]);
                        try {
                            truck.refuel(fuel);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
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
