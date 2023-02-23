package A4_NeedForSpeed;

public class Main {

    public static void main(String[] args) {

    }
}
/*NOTE: You need a public class Main. Create the following hierarchy with the following classes:

                                  Vehicle
            Motorcycle                              Car
RaceMotorcycle      CrossMotorcycle     FamilyCar       SportCar

Create a base class Vehicle. It should contain the following members:
•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
•	fuelConsumption – double
•	fuel – double
•	horsePower – int
•	Getters and Setters for the fields
•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
•	void drive(double kilometers)
o	The drive method should have the functionality to reduce the fuel based on the traveled kilometers and fuel consumption.
Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving.
The default fuel consumption for Vehicle is 1.25. Some of the classes have different default fuel consumption:
•	SportCar – DEFAULT_FUEL_CONSUMPTION = 10
•	RaceMotorcycle – DEFAULT_FUEL_CONSUMPTION = 8
•	Car – DEFAULT_FUEL_CONSUMPTION = 3
*/
