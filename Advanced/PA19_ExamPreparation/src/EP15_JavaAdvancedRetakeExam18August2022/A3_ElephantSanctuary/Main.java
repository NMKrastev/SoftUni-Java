package EP15_JavaAdvancedRetakeExam18August2022.A3_ElephantSanctuary;

public class Main {

    public static void main(String[] args) {
        // Initialize the repository
        Habitat park = new Habitat(10);

// Initialize entity
        Elephant firstElephant = new Elephant("Bobby", 10, "Thailand Zoo");
// Print Elephant
        System.out.println(firstElephant); //Bobby 10 - Thailand Zoo

// Add Elephant
        park.add(firstElephant);

// Remove Elephant
        System.out.println(park.remove("Bobby")); //true
        System.out.println(park.remove("Lola")); //false
        Elephant secondElephant = new Elephant("Bibi", 5, "Private Zoo");
        Elephant thirdElephant = new Elephant("Lola", 7, "National Circus of Thailand");
        park.add(secondElephant);
        park.add(thirdElephant);

// Get Oldest Elephant
        Elephant oldest = park.getOldestElephant();
        System.out.println(oldest); //Lola 7 - National Circus of Thailand

        Elephant elephant = park.getElephant("Private Zoo");
        System.out.println(elephant); //Bibi 5 - Private Zoo

// All elephants in the park
        System.out.println(park.getAllElephants()); //2

// Information Report
        System.out.println(park.getReport());

//Saved elephants in the park:
//Bibi came from: Private Zoo
//Lola came from: National Circus of Thailand

    }
}
/*Your task is to create a repository that stores items by creating the classes described below.
First, write a Java class Elephant with the following fields:
•	name: String
•	age: int
•	retiredFrom: String
The class constructor should receive a name, age, and the place where the elephant was retired from.
You need to create the appropriate getters and setters. The class should override the toString() method in the following format:
"{name} {age} - {retiredFrom}"
Next, write a Java class Habitat that has data (a collection, which stores the Elephants in the Sanctuary).
All entities inside the repository have the same fields. Also, the Habitat class should have those fields:
•	capacity: int
The class constructor should receive capacity. Also, it should initialize the data with a new collection instance.
Implement the following features:
•	Field data – List that holds added elephants
•	Method add(Elephant elephant) – adds an entity to the data if there is an empty space for the elephant.
•	Method remove(String name) – removes the elephant by given name, if such exists, and returns boolean.
•	Method getElephant(String retiredFrom) – returns the elephant retired from the given place or null if no such elephant exists.
•	Method getOldestElephant() – returns the oldest Elephant.
•	Getter getAllElephants() – returns the number of elephants.
•	getReport() – returns a String in the following format:
"Saved elephants in the park:
		 {name} came from: {retiredFrom}
          {name} came from: {retiredFrom}
          (…)"
Constraints
•	The age of the elephants will always be a positive number.
*/
