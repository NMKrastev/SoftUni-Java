import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A3_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A3_Engine> engineList = new ArrayList<>();
        List<A3_Car> carList = new ArrayList<>();

        int numOfEngines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfEngines; i++) {

            String[] engineInfo = scanner.nextLine().split("\\s+");

            A3_Engine engine = new A3_Engine(engineInfo[0], engineInfo[1]);
            if (engineInfo.length == 3) {
                if (Character.isDigit(engineInfo[2].charAt(0))) {
                    engine.setDisplacement(engineInfo[2]);
                } else {
                    engine.setEfficiency(engineInfo[2]);
                }
            } else if (engineInfo.length == 4){
                engine.setDisplacement(engineInfo[2]);
                engine.setEfficiency(engineInfo[3]);
            }
            engineList.add(engine);
        }

        int numOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCars; i++) {

            String[] carInfo = scanner.nextLine().split("\\s+");

            A3_Car car = new A3_Car(carInfo[0], carInfo[1]);
            if (carInfo.length == 3) {
                if (Character.isDigit(carInfo[2].charAt(0))) {
                    car.setWeight(carInfo[2]);
                } else {
                    car.setColor(carInfo[2]);
                }
            } else if (carInfo.length == 4) {
                car.setWeight(carInfo[2]);
                car.setColor(carInfo[3]);
            }
            carList.add(car);
        }

        for (A3_Car cars : carList) {

            for (A3_Engine engines : engineList) {
                if (cars.getEngine().equals(engines.getModel())) {
                    System.out.printf("%s:\n  %s:\n    Power: %s\n    Displacement: %s\n    Efficiency: %s\n  Weight: %s\n  Color: %s\n",
                            cars.getModel(), engines.getModel(), engines.getPower(), engines.getDisplacement(), engines.getEfficiency(),
                            cars.getWeight(), cars.getColor());
                    break;
                }
            }
        }
    }
}
/*Define two classes Car and Engine. A Car has a model, engine, weight, and color. An Engine has a model, power,
displacement, and efficiency. A Car's weight and color and its Engine's displacements and efficiency are optional.
On the first line, you will read a number N which will specify how many lines of engines you will receive,
on each of the next N lines, you will receive information about an Engine in the following format
"{Model} {Power} {Displacement} {Efficiency}". After the lines with engines, on the next line, you will receive
a number M – specifying the number of Cars that will follow, on each of the next M lines, information about a Car
will follow in the following format "{Model} {Engine} {Weight} {Color}", where the engine in the format will be the
model of an existing Engine. When creating the object for a Car, you should keep a reference to the real engine in it,
instead of just the engine's model, note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in the format defined below,
if any of the optional fields have not been given, print "n/a" in its place instead:
"{CarModel}:
  {EngineModel}:
    Power: {EnginePower}
    Displacement: {EngineDisplacement}
    Efficiency: {EngineEfficiency}
  Weight: {CarWeight}
  Color: {CarColor}"
*/