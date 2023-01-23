package A7_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, Person> personsMap = new LinkedHashMap<>();
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String relation = data[1];
            Person person = null;

            if (personsMap.containsKey(name)) {
                person = personsMap.get(name);
            } else {
                person = new Person(name);
                personsMap.put(name, person);
            }

            Car car = null;
            Child child = null;
            Company company = null;
            Parent parent = null;
            Pokemon pokemon = null;
            switch (relation) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    pokemon = new Pokemon(pokemonName, pokemonType);
                    person.getPokemonsList().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    parent = new Parent(parentName, parentBirthday);
                    person.getParentsList().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    child = new Child(childName, childBirthday);
                    person.getChildrenList().add(child);
                    break;
                case "car":
                    String currentCar = data[2];
                    String carSpeed = data[3];
                    car = new Car(currentCar, carSpeed);
                    person.setCar(car);
                    break;
            }
        }
        input = scanner.nextLine();
        System.out.println(personsMap.get(input).toString());
    }
}
/*Google is always watching you, so it should come as no surprise that they know everything about you
(even your pokemon collection), since you're really good at writing classes, Google asked you to design a Class that
can hold all the information they need for people.
You will receive an unknown number of rows from the console until you receive the "End" command, on each of those lines,
there will be information about a person in one of the following formats:
•	"{Name} company {companyName} {department} {salary}"
•	"{Name} pokemon {pokemonName} {pokemonType}"
•	"{Name} parents {parentName} {parentBirthday}"
•	"{Name} children {childName} {childBirthday}"
•	"{Name} car {carModel} {carSpeed}"
You should structure all information about a person in a class with nested subclasses. People's names are unique -
there won't be 2 people with the same name, a person can also have only 1 company and car, but can have multiple
parents, children, and pokemons. After the command "End" is received on the next line, you will receive a single name,
you should print all information about that person. Note that information can change during the input, for instance,
if we receive multiple lines which specify a person's company, only the last one should be the one remembered.
The salary must be formatted to two decimal places after the separator.
Note: print the information in the format:
	"{personName}
	Company:
	{companyName} {companyDepartment} {salary}
	...
	Children:
	{childName} {childBirthday}
	{childName} {childBirthday}"
*/
