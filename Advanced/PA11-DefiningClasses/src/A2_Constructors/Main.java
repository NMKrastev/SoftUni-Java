package A2_Constructors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Car car = data.length == 1
                    ? new Car(data[0])
                    : new Car(data[0], data[1], Integer.parseInt(data[2]));

            car.carInfo();
        }
    }
}
/*Make proper constructors for the Car class, so you can create car objects with a different type of input information.
If you miss information about the field of type String set the value to "unknown", and for an integer, fieldset -1.
First, declare a constructor which takes only the car brand as a parameter:
Also, create a constructor which sets all the fields.
Read information about cars the same way as the previous task, however, this time uses constructors to create the objects,
not creating an object with the default constructor. You should be able to handle different types of input,
the format will be the same as the previous task, but this time some of the data may be missing. For example,
you can get only the car brand – which means you have to set the car model to "unknown" and the Horsepower value to -1.
There will be lines with complete car data, declare constructor which sets all the fields.
You have to add the car objects to a collection of your choice and print the data as in the previous task.
The input will always have one or three elements on each line.
*/
