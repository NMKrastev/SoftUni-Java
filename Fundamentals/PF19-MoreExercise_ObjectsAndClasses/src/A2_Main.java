import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A2_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A2_Car> carsList = new ArrayList<>();

        int numOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCars; i++) {
            //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            String input = scanner.nextLine();

            A2_Engine engine = new A2_Engine(Integer.parseInt(input.split("\\s+")[1]),
                    Integer.parseInt(input.split("\\s+")[2]));

            A2_Cargo cargo = new A2_Cargo(Integer.parseInt(input.split("\\s+")[3]), input.split("\\s+")[4]);

            A2_Tires tireOne = new A2_Tires(Double.parseDouble(input.split("\\s+")[5]), Integer.parseInt(input.split("\\s+")[6]));
            A2_Tires tireTwo = new A2_Tires(Double.parseDouble(input.split("\\s+")[7]), Integer.parseInt(input.split("\\s+")[8]));
            A2_Tires tireThree = new A2_Tires(Double.parseDouble(input.split("\\s+")[9]), Integer.parseInt(input.split("\\s+")[10]));
            A2_Tires tireFour = new A2_Tires(Double.parseDouble(input.split("\\s+")[11]), Integer.parseInt(input.split("\\s+")[12]));

            A2_Car car = new A2_Car(input.split("\\s+")[0], engine, cargo, tireOne, tireTwo, tireThree, tireFour);
            carsList.add(car);

        }

        String cargo = scanner.nextLine();
        List<String> result = new ArrayList<>();

        if (cargo.equals("fragile")) {
            carsList.forEach(e -> {
                if (e.getCargos().getCargoType().equals("fragile")) {
                    for (A2_Tires tireSet : e.getTires()) {
                        if (tireSet.getTirePressure() < 1) {
                            result.add(e.getModel());
                            break;
                        }
                    }
                }
            });
        } else {
            carsList.forEach(e -> {
                if (e.getCargos().getCargoType().equals("flamable") &&
                        e.getEngines().getEnginePower() > 250) {
                    result.add(e.getModel());
                }
            });
        }

        result.forEach(System.out::println);
    }
}
/*You are the owner of a courier company and want to make a system for tracking your cars and their cargo.
Define a class Car that holds information about the model, engine, cargo, and a collection of exactly 4 tires.
The engine, cargo, and tire should be separate classes, and create a constructor that receives all information about
the Car and creates and initializes its inner components (engine, cargo, and tires).
On the first line of input you will receive a number N - the number of cars you have, on each of the next N lines
you will receive information about a car in the format "{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
{Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}"
 where the speed, power, weight and tire age are integers, tire pressure is a double.
After the N lines, you will receive a single line with one of 2 commands "fragile" or "flammable",
if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1
if the command is "flammable" print all cars whose Cargo Type is "flammable" and have Engine Power > 250.
The cars should be printed in order to appear in the input.*/