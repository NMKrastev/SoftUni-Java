package A4_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        while (num-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tireOnePressure = Double.parseDouble(data[5]);
            int tireOneAge = Integer.parseInt(data[6]);
            double tireTwoPressure = Double.parseDouble(data[7]);
            int tireTwoAge = Integer.parseInt(data[8]);
            double tireThreePressure = Double.parseDouble(data[9]);
            int tireThreeAge = Integer.parseInt(data[10]);
            double tireFourPressure = Double.parseDouble(data[11]);
            int tireFourAge = Integer.parseInt(data[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tireOne = new Tires(tireOnePressure, tireOneAge);
            Tires tireTwo = new Tires(tireTwoPressure, tireTwoAge);
            Tires tireThree = new Tires(tireThreePressure, tireThreeAge);
            Tires tireFour = new Tires(tireFourPressure, tireFourAge);

            Car car = new Car(model, engine, cargo, tireOne, tireTwo, tireThree, tireFour);
            carsList.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            carsList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> {
                        for (Tires tires : car.getTires()) {
                            if (tires.getTirePressure() < 1) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(System.out::println);
        } else if (command.equals("flamable")) {
            carsList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
/*You are the owner of a courier company, and you want to make a system for tracking your cars and their cargo.
Define a class Car that holds information about the model, engine, cargo, and a collection of exactly 4 tires.
The engine, cargo, and tire should be separate classes, create a constructor that receives all information about the
Car and creates and initializes its inner components (engine, cargo, and tires).
On the first line of the input, you will receive a number N - the number of cars you have, on each of the next N lines,
you will receive information about a car in the format:
"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}", where the speed, power, weight and tire age are integers, tire pressure is a double.
After the N lines, you will receive a single line with one of 2 commands "fragile" or "flamable",
if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1
if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
The cars should be printed in order of appearing in the input.
*/