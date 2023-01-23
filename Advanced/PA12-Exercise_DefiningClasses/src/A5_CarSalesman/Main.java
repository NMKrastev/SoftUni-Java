package A5_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();
        while (numOfEngines-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String engineModel = data[0];
            String enginePower = data[1];

            Engine engine = null;
            switch (data.length) {
                case 2:
                    engine = new Engine(engineModel, enginePower);
                    break;
                case 3:
                    if (Character.isLetter(data[2].charAt(0))) {
                        String engineEfficiency = data[2];
                        engine = new Engine(engineModel, enginePower);
                        engine.setEngineEfficiency(engineEfficiency);
                    } else {
                        String engineDisplacement = data[2];
                        engine = new Engine(engineModel, enginePower);
                        engine.setEngineDisplacement(engineDisplacement);
                    }
                    break;
                case 4:
                    String engineDisplacement = data[2];
                    String engineEfficiency = data[3];
                    engine = new Engine(engineModel, enginePower);
                    engine.setEngineDisplacement(engineDisplacement);
                    engine.setEngineEfficiency(engineEfficiency);
                    break;
            }
            enginesList.add(engine);
        }

        int numOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        while (numOfCars-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            String carEngine = data[1];

            Car car = null;
            switch (data.length) {
                case 2:
                    car = new Car(carModel, carEngine);
                    break;
                case 3:
                    if (Character.isLetter(data[2].charAt(0))) {
                        String carColor = data[2];
                        car = new Car(carModel, carEngine);
                        car.setCarColor(carColor);
                    } else {
                        String carWeight = data[2];
                        car = new Car(carModel, carEngine);
                        car.setCarWeight(carWeight);
                    }
                    break;
                case 4:
                    String carWeight = data[2];
                    String carColor = data[3];
                    car = new Car(carModel, carEngine);
                    car.setCarWeight(carWeight);
                    car.setCarColor(carColor);
                    break;
            }
            carsList.add(car);
        }

        carsList.stream().forEach(car -> {
            enginesList.forEach(engine -> {
                if (car.getCarEngine().equals(engine.getEngineModel())) {
                    System.out.printf("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s\n",
                            car.getCarModel(), engine.getEngineModel(), engine.getEnginePower(), engine.getEngineDisplacement(),
                            engine.getEngineEfficiency(), car.getCarWeight(), car.getCarColor());
                }
            });
        });
    }
}
