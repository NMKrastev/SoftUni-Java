import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A5_Vehicle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A5_VehicleCatalogue> catalogueList = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String typeOfVehicle = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            String color = input.split("\\s+")[2];
            int horsepower = Integer.parseInt(input.split("\\s+")[3]);

            A5_VehicleCatalogue vehicle = new A5_VehicleCatalogue(typeOfVehicle, model, color, horsepower);

            catalogueList.add(vehicle);

            input = scanner.nextLine();

            if (input.equals("End")) {
                input = scanner.nextLine();
                while (!input.equals("Close the Catalogue")) {

                    getCatalogue(input, catalogueList);

                    input = scanner.nextLine();
                }
                input = "End";
            }
        }
        double carsAverageHorsePower = getAverageHorsePower("car", catalogueList);
        double trucksAverageHorsePower = getAverageHorsePower("truck", catalogueList);

        System.out.printf("Cars have average horsepower of: %.2f.\n", carsAverageHorsePower);
        System.out.printf("Trucks have average horsepower of: %.2f.\n", trucksAverageHorsePower);
    }

    private static double getAverageHorsePower(String typeOfVehicle, List<A5_VehicleCatalogue> catalogueList) {

        int sumOfHP = 0;
        int count = 0;
        for (A5_VehicleCatalogue vehicle : catalogueList) {
            if (vehicle.getTypeOfVehicle().equals(typeOfVehicle)) {
                sumOfHP += vehicle.getHorsepower();
                count++;
            }
        }

        if (sumOfHP == 0) {
            return 0;
        } else {
            return sumOfHP * 1.0 / count;
        }
    }

    public static void getCatalogue(String model, List<A5_VehicleCatalogue> catalogueList) {

        for (A5_VehicleCatalogue vehicle : catalogueList) {

            if (vehicle.getModel().equals(model)) {
                System.out.printf("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d\n",
                        vehicle.getTypeOfVehicle().substring(0, 1).toUpperCase() + vehicle.getTypeOfVehicle().substring(1),
                        vehicle.getModel(), vehicle.getColor(), vehicle.getHorsepower());
                break;
            }
        }
    }
}
/*You have to make a catalog for vehicles. You will receive two types of vehicles - a car or a truck.
Until you receive the command "End" you will receive lines of input in the format:
{typeOfVehicle} {model} {color} {horsepower}
After the "End" command, you will start receiving models of vehicles. Print for every received
vehicle its data in the format:
Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}
When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower
for the cars and the trucks in the format:
"{typeOfVehicles} have average horsepower of {averageHorsepower}."
The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by the
total count of vehicles from the same type.
Format the answer to the 2nd decimal point.
Constraints
•	The type of vehicle will always be a car or truck.
•	You will not receive the same model twice.
•	The received horsepower will be an integer in the interval [1…1000].
•	You will receive at most 50 vehicles.
•	Single whitespace will be used for the separator.*/